package cn.ustb.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ustb.oa.base.BaseDaoImpl;
import cn.ustb.oa.dao.IDepartmentDao;
import cn.ustb.oa.domain.Department;

@Repository
@SuppressWarnings("unchecked")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements IDepartmentDao{

	/**
	 * 查询顶级部门列表
	 */
	@Override
	public List<Department> findTopList() {
		String hql = "FROM Department d WHERE d.parent IS NULL";
		return this.getSession().createQuery(hql).list();
	}

	/**
	 * 根据父部门id查询子部门列表
	 */
	@Override
	public List<Department> findChildren(Long parentId) {	
		String hql = "FROM Department d WHERE d.parent.id = ?";
		return this.getSession().createQuery(hql).setParameter(0, parentId).list();
	}

}
