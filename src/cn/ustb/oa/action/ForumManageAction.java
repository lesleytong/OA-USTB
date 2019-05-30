package cn.ustb.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ustb.oa.base.BaseAction;
import cn.ustb.oa.domain.Forum;

/**
 * 论坛管理
 * @author Lenovo
 *
 */
@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum>{
	
	/**
	 * 查询板块列表
	 */
	public String list(){
		List<Forum> list = forumManageService.findAll();
		getValueStack().set("list", list);
		return "list";
	}
	
	/**
	 * 根据id删除版块
	 */
	public String delete() {
		
		forumManageService.delete(model);
		return "toList";
	}
	
	/**
	 * 跳转到添加版块页面
	 */
	public String addUI() {
		//不用准备数据，直接跳转即可
		return "addUI";
	}
	
	/**
	 * 添加版块
	 */
	public String add() {
		forumManageService.save(model);
		return "toList";
	}
	
	/**
	 * 跳转到修改版块页面
	 */
	public String editUI() {
		//先查询
		Forum forum = forumManageService.getById(model.getId());
		//压栈
		getValueStack().push(forum);
		//跳转到修改页面
		return "editUI";
	}
	
	/**
	 * 修改版块
	 */
	public String edit() {
		//先查询，再修改
		Forum forum = forumManageService.getById(model.getId());
		
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		forumManageService.update(forum);
		
		return "toList";
	}
	
	/**
	 * 上移
	 */
	
	public String moveUp() {
		
		forumManageService.moveUp(model.getId());
		
		return "toList";
	}
	
	/**
	 * 下移
	 */
	public String moveDown() {
		
		forumManageService.moveDown(model.getId());
		
		return "toList";
	}
	
}
