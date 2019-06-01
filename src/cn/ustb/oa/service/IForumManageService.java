package cn.ustb.oa.service;

import java.util.List;

import cn.ustb.oa.domain.Forum;
import cn.ustb.oa.domain.PageBean;
import cn.ustb.oa.utils.HQLHelper;

public interface IForumManageService {

	public List<Forum> findAll();

	public void delete(Forum model);

	public void save(Forum model);

	public Forum getById(Long id);

	public void update(Forum forum);

	public void moveUp(Long id);

	public void moveDown(Long id);

	public PageBean getPageBean(HQLHelper hh, int currentPage);

}
