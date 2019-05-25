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
		
		List<Department> list = null;
		
		if(parentId == null) {
			//查询顶级部门列表
			list = departmentService.findTopList();
			
		}else {
			//根据顶级部门id查询子部门列表
			list = departmentService.findChildren(parentId);
		}
		
		
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
	
	
	/**
	 * 跳转到修改页面
	 */
	public String editUI() {
		//准备数据：部门列表
		List<Department> list = departmentService.findAll();
		
		//准备数据：根据id查询要修改的部门
		Department dept = departmentService.getById(model.getId());
		
		//压栈
		getValueStack().set("departmentList", list);
		getValueStack().push(dept);
		
		//如果不是顶级部门，才设置
		if(dept.getParent() != null) {
			//设置要修改的部门的parentId，用于回显
			parentId = dept.getParent().getId();			
		}
		
		return "editUI";
	}
	
	/**
	 * 修改部门
	 */
	public String edit() {
		//修改的第一步都是先查询，查到要修改的是谁
		Department dept = departmentService.getById(model.getId());
		
		dept.setName(model.getName());
		dept.setDescription(model.getDescription());
		
		if(parentId != null) {
			Department parent = departmentService.getById(parentId);
			
			dept.setParent(parent);
		}else {
			dept.setParent(null);
		}
		
		departmentService.update(dept);
		
		return "toList";
	}
	
}







