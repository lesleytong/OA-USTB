package cn.ustb.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ustb.oa.dao.IDepartmentDao;
import cn.ustb.oa.domain.Department;
import cn.ustb.oa.service.IDepartmentService;

/**
 * 部门管理
 * @author Lenovo
 *
 */
@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService{

	@Resource
	private IDepartmentDao departmentDao;
	
	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	@Override
	public void delete(Department model) {
		departmentDao.delete(model.getId());
	}

	@Override
	public Department getById(Long parentId) {
		return departmentDao.getById(parentId);
	}

	@Override
	public void save(Department model) {
		departmentDao.save(model);
		
	}
	
	

}
