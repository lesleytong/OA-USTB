package cn.ustb.oa.action;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ustb.oa.base.BaseAction;
import cn.ustb.oa.domain.Department;
import cn.ustb.oa.domain.Role;
import cn.ustb.oa.domain.User;
import cn.ustb.oa.utils.DepartmentUtils;
import cn.ustb.oa.utils.MD5Utils;

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
		
		User user = userService.getById(model.getId());
		getValueStack().push(user);
		
		//准备数据（部门树形列表和岗位列表）
		List<Department> topList = departmentService.findTopList();
		List<Department> treeList = DepartmentUtils.getTreeList(topList, null);
		
		List<Role> roleList = roleServie.findAll();
		
		getValueStack().set("treeList", treeList);
		getValueStack().set("roleList", roleList);
		
		//如果该用户有属于的部门
		if(user.getDepartment() != null) {
			//查询用户部门Id，用于回显
			departmentId = user.getDepartment().getId();
		}
		
		Set<Role> roles =user.getRoles();
		
		//如果该用户有属于的岗位
		if(roles != null && roles.size()>0) {
			//获取当前用户的岗位id，用于回显
			int size = roles.size();
			roleIds = new Long[size];
			int c = 0;
			for(Role role : roles) {
				roleIds[c++] = role.getId();
			}
		}
		
		return "editUI";
	}
	
	/**
	 * 根据id修改用户
	 */
	public String edit() {
		//先查询，再修改
		User user = userService.getById(model.getId());
		
		//普通属性的修改设置
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setGender(model.getGender());
		user.setPhone(model.getPhone());
		user.setEmail(model.getEmail());
		user.setDescription(model.getDescription());
		
		//关联属性的修改设置
		//部门
		if(departmentId != null) {
			//先查询，再修改
			Department dept = departmentService.getById(departmentId);
			user.setDepartment(dept);
		}else {	//这里必须写else，因为修改的时候如果选择了“请选择”，则上级部门修改为null
			user.setDepartment(null);
		}
		
		//岗位
		if(roleIds != null && roleIds.length>0) {
			//先查询，再修改
			List<Role> roles = roleServie.getByIds(roleIds);
			user.setRoles(new HashSet<Role>(roles));	//List变Set，用HashSet
		}else {	//这里必须写else，因为修改的时候如果没有选中岗位，则岗位修改为null
			user.setRoles(null);
		}
		
		userService.update(user);
		
		return "toList";
	}
	
	/**
	 * 初始化密码
	 */
	public String intiPassword() {
		//先查询
		User user = userService.getById(model.getId());
		user.setPassword(MD5Utils.md5("1234"));	//因为登录密码是用MD5加密后和数据库中同样加密的密码作比较
		
		userService.update(user);
		return "toList";
	}
	
	/**
	 * 查询当前用户名是否存在
	 */
	public String findByLoginName() {
		
		String loginName = model.getLoginName();
		int count = userService.findByLoginName(loginName);
		
		ServletActionContext.getResponse().setContentType("text/html;character=utf-8");
		String flag = "1";
		if(count > 0) {
			//当前登录名存在，不能使用
			flag = "0";
		}
		try {
			ServletActionContext.getResponse().getWriter().print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return NONE;
	}
}






