package cn.ustb.oa.service;

import java.util.List;

import cn.ustb.oa.domain.Forum;

public interface IForumService {

	public List<Forum> findAll();

	public Forum getById(Long id);

}
