package cn.ustb.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.util.ValueStack;

import cn.ustb.oa.base.BaseAction;
import cn.ustb.oa.domain.Role;
import cn.ustb.oa.service.impl.RoleServiceImpl;

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
	
	/**
	 * 跳转到修改页面
	 */
	public String editUI(){
		//根据id查询岗位，用于回显
		Role role = roleServie.getById(model.getId());
		
		getValueStack().push(role);
		
		return "editUI";
	}
	
	/**
	 * 修改岗位
	 */
	public String edit(){
		//先查询，再修改
		Role role = roleServie.getById(model.getId());
		
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		
		roleServie.update(role);
		
		return "toList";
	}
	
}



