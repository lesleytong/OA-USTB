package cn.ustb.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.stereotype.Service;

import cn.ustb.oa.dao.IForumDao;
import cn.ustb.oa.domain.Forum;
import cn.ustb.oa.domain.PageBean;
import cn.ustb.oa.service.IForumService;
import cn.ustb.oa.utils.HQLHelper;

/**
 * 参与版块操作
 * @author zhaoqx
 *
 */
@Service
@Transactional
public class ForumServiceImpl implements IForumService{
	
	@Resource
	private IForumDao forumDao;
	
	public List<Forum> findAll() {
		return forumDao.findAll();
	}

	@Override
	public Forum getById(Long id) {
		return forumDao.getById(id);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		return forumDao.getPageBean(hh, currentPage);
	}


}
