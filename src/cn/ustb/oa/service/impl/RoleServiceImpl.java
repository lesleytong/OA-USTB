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
	
}
