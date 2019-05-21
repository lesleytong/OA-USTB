package cn.ustb.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ustb.oa.base.BaseAction;
import cn.ustb.oa.domain.Department;

/**
 * 部门管理
 * @author Lenovo
 *
 */
@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{

	/**
	 * 查询部门列表
	 */
	public String list() {
		
		List<Department> list = departmentService.findAll();
		
		getValueStack().set("list", list);	//查出来的是列表，就用set
		
		return "list";
	}
	
	/**
	 * 根据id删除部门
	 */
	public String delete() {
		
		departmentService.delete(model);
		
		return "toList";
	}
	
	
	
}
