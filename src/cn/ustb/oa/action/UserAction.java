package cn.ustb.oa.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ustb.oa.base.BaseAction;
import cn.ustb.oa.domain.Department;
import cn.ustb.oa.domain.Role;
import cn.ustb.oa.domain.User;
import cn.ustb.oa.utils.DepartmentUtils;

/**
 * 用户管理
 * @author Lenovo
 *
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	//属性驱动
	private Long departmentId;	//部门id
	private Long[] roleIds;	    //岗位id
	
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

	/**
	 * 查询用户列表
	 */
	public String list() {
		
		List<User> list = userService.findAll();
		getValueStack().set("userList", list);
		return "list";
	}
	
	/**
	 * 删除用户
	 */
	public String delete() {
		userService.delete(model);
		return "toList";
	}
	
	/**
	 * 跳转到添加用户页面
	 */
	public String addUI() {
		//准备数据（部门树形列表和岗位列表）
		List<Department> topList = departmentService.findTopList();
		List<Department> treeList = DepartmentUtils.getTreeList(topList, null);
		
		List<Role> roleList = roleServie.findAll();
		
		getValueStack().set("treeList", treeList);
		getValueStack().set("roleList", roleList);
		
		return "addUI";
	}
	
	/**
	 * 添加用户
	 */
	public String add() {
		
		if(departmentId != null) {
			Department dept = departmentService.getById(departmentId);
			model.setDepartment(dept);	//用户关联部门
		}
		if(roleIds != null && roleIds.length>0) {
			List<Role> roleList = roleServie.getByIds(roleIds);
			model.setRoles(new HashSet<Role>(roleList));	//List变Set，用HashSet
			
		}
		
		userService.save(model);
		
		return "toList";
	}
	
	/**
	 * 跳转到用户修改页面
	 */
	public String editUI() {
		
		return "editUI";
	}
	
	/**
	 * 根据id修改用户
	 */
	public String edit() {
		
		return "toList";
	}
	
	/**
	 * 初始化密码
	 */
	public String intiPassword() {
		
		return "toList";
	}
}
