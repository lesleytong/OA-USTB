package cn.ustb.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.stereotype.Service;

import cn.ustb.oa.dao.IForumDao;
import cn.ustb.oa.domain.Forum;
import cn.ustb.oa.service.IForumService;

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


}
