package cn.ustb.oa.service;

import java.util.List;

import cn.ustb.oa.domain.PageBean;
import cn.ustb.oa.domain.User;
import cn.ustb.oa.utils.HQLHelper;

public interface IUserService {

	public List<User> findAll();

	public void delete(User model);

	public void save(User model);

	public User getById(Long id);

	public void update(User user);

	public int findByLoginName(String loginName);

	public PageBean getPageBean(HQLHelper hh, int currentPage);

}
