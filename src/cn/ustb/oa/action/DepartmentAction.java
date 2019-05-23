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

	private Long parentId;
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

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
	
	/**
	 * 跳转到部门添加页面
	 */
	public String addUI() {
		//准备部门列表数据，用于select框显示
		List<Department> list = departmentService.findAll();
		
		getValueStack().set("departmentList", list);
		
		return "addUI";
	}
	
	
	/**
	 * 添加部门
	 */
	public String add() {
		if(parentId != null) {
			Department parent = departmentService.getById(parentId);
			model.setParent(parent);	//设置上级部门
		}else {
			model.setParent(null);
		}
		
		departmentService.save(model);
		
		return "toList";
	}
	
	
}
