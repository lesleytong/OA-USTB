package cn.ustb.oa.dao;

import java.util.List;

import cn.ustb.oa.base.IBaseDao;
import cn.ustb.oa.domain.Department;

public interface IDepartmentDao extends IBaseDao<Department>{

	public List<Department> findTopList();

	public List<Department> findChildren(Long parentId);

}
