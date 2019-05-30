package cn.ustb.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import cn.ustb.oa.service.IBookService;
import cn.ustb.oa.service.IDepartmentService;
import cn.ustb.oa.service.IForumManageService;
import cn.ustb.oa.service.IRoleService;
import cn.ustb.oa.service.IUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 通用父类Action
 * @author zhaoqx
 *
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	
	@Resource
	protected IBookService bookService;
	@Resource
	protected IRoleService roleServie;
	@Resource
	protected IDepartmentService departmentService;
	@Resource
	protected IUserService userService;
	@Resource
	protected IForumManageService forumManageService;
	
	
	//在构造方法中获得model类型
	public BaseAction(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();//父类Action类型
		Type[] types = type.getActualTypeArguments();
		Class<T> clazz = (Class<T>) types[0];
		try {
			model = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	protected T model;

	@Override
	public T getModel() {
		return model;
	}
	
	/**
	 * 获得值栈
	 */
	protected ValueStack getValueStack() {
		return ActionContext.getContext().getValueStack();
	}
	
}



