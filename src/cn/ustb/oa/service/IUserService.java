package cn.ustb.oa.service;

import java.util.List;

import cn.ustb.oa.domain.User;

public interface IUserService {

	public List<User> findAll();

	public void delete(User model);

	public void save(User model);

}
