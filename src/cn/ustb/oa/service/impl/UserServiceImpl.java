package cn.ustb.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ustb.oa.dao.IUserDao;
import cn.ustb.oa.domain.User;
import cn.ustb.oa.service.IUserService;
/**
 * 用户管理
 * @author Lenovo
 *
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Resource
	private IUserDao userDao;

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void delete(User model) {
		userDao.delete(model.getId());
	}

	@Override
	public void save(User model) {
		userDao.save(model);
	}
	
	
	
}
