package cn.ustb.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ustb.oa.dao.IRoleDao;
import cn.ustb.oa.domain.Role;
import cn.ustb.oa.service.IRoleService;
/**
 * 岗位管理
 * @author Lenovo
 *
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService{

	@Resource
	private IRoleDao roleDao;
	
	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public void delete(Role model) {
		roleDao.delete(model.getId());
	}

	@Override
	public Role getById(Long id) {
		return roleDao.getById(id);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
	}

	@Override
	public void save(Role model) {
		roleDao.save(model);
		
	}

	@Override
	public List<Role> getByIds(Long[] roleIds) {
		return roleDao.getByIds(roleIds);
	}


	
}
