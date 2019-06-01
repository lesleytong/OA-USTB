package cn.ustb.oa.service;

import java.util.List;

import cn.ustb.oa.domain.Forum;
import cn.ustb.oa.domain.PageBean;
import cn.ustb.oa.utils.HQLHelper;

public interface IForumService {

	public List<Forum> findAll();

	public Forum getById(Long id);

	public PageBean getPageBean(HQLHelper hh, int currentPage);

}
