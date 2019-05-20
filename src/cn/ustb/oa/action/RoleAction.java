package cn.ustb.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.util.ValueStack;

import cn.ustb.oa.base.BaseAction;
import cn.ustb.oa.domain.Role;

/**
 * 
 * 岗位管理
 * @author Lenovo
 *
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
	/**
	 * 查询岗位列表
	 */
	public String list() {
		//查询
		List<Role> list = roleServie.findAll();
		
		//得到值栈
		ValueStack vs = getValueStack();
		
		//压栈
		vs.set("list", list);
		
		return "list";
	}
	
	/**
	 * 根据id删除岗位
	 */
	public String delete() {
		
		roleServie.delete(model);
		
		return "toList";
	}
	
}
