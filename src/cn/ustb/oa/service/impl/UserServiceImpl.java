package cn.ustb.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ustb.oa.dao.IUserDao;
import cn.ustb.oa.domain.PageBean;
import cn.ustb.oa.domain.User;
import cn.ustb.oa.service.IUserService;
import cn.ustb.oa.utils.HQLHelper;
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

	@Override
	public User getById(Long id) {
		return userDao.getById(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);		
	}

	@Override
	public int findByLoginName(String loginName) {
		return userDao.findByLoginName(loginName);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		return userDao.getPageBean(hh, currentPage);
	}
	
	
	
}
