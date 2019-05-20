package cn.ustb.oa.service;

import java.util.List;

import cn.ustb.oa.domain.Role;

public interface IRoleService {

	public List<Role> findAll();

	public void delete(Role model);

	public Role getById(Long id);

	public void update(Role role);
}
