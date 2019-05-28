package cn.ustb.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ustb.oa.base.BaseAction;
import cn.ustb.oa.domain.User;

/**
 * 用户管理
 * @author Lenovo
 *
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
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
		
		return "toList";
	}
	
	/**
	 * 跳转到添加用户页面
	 */
	public String addUI() {
		
		return "addUI";
	}
	
	/**
	 * 添加用户
	 */
	public String add() {
		
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
