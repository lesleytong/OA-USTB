package cn.ustb.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ustb.oa.base.BaseAction;
import cn.ustb.oa.domain.Forum;
import cn.ustb.oa.domain.Topic;

/**
 * 参与版块操作
 * @author zhaoqx
 *
 */
@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum>{
	/**
	 * 查询版块列表
	 */
	public String list(){
		List<Forum> list = forumService.findAll();
		getValueStack().set("list", list);
		return "list";
	}
	
	/**
	 * 查询主题列表（单个 版块）
	 */
	public String show(){
		
		//根据版块id查询版块，用于页面显示
		Forum forum = forumService.getById(model.getId());
		getValueStack().push(forum);
		
		//根据版块查询主题列表
		List<Topic> topicList = topicService.findTopicByForum(model);
		getValueStack().set("topicList", topicList);
		return "forumShow";
	}
}
