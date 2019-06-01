package cn.ustb.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ustb.oa.dao.IForumManageDao;
import cn.ustb.oa.domain.Forum;
import cn.ustb.oa.domain.PageBean;
import cn.ustb.oa.service.IForumManageService;
import cn.ustb.oa.utils.HQLHelper;
/**
 * 版块管理
 * @author Lenovo
 *
 */
@Service
@Transactional
public class ForumManageServiceImpl implements IForumManageService {

	@Resource
	private IForumManageDao forumManageDao;
	
	@Override
	public List<Forum> findAll() {
		return forumManageDao.findAll();
	}

	@Override
	public void delete(Forum model) {
		forumManageDao.delete(model.getId());	
	}

	@Override
	public void save(Forum model) {
		forumManageDao.save(model);
	}

	@Override
	public Forum getById(Long id) {
		return forumManageDao.getById(id);
	}

	@Override
	public void update(Forum forum) {
		forumManageDao.update(forum);		
	}

	@Override
	public void moveUp(Long id) {		
		forumManageDao.moveUp(id);
	}

	@Override
	public void moveDown(Long id) {
		forumManageDao.moveDown(id);		
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		return forumManageDao.getPageBean(hh, currentPage);
	}
	
	
}
