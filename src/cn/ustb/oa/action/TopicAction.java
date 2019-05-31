package cn.ustb.oa.action;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ustb.oa.base.BaseAction;
import cn.ustb.oa.domain.Forum;
import cn.ustb.oa.domain.Topic;

/**
 * 主题操作
 * @author Lenovo
 *
 */
@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic>{
	
	private Long forumId;//属性驱动，版块id；别忘了get/set方法
	
	/**
	 * 跳转到发表主题页面
	 */
	public String addUI(){
		//根据版块id查询板块信息，用于页面显示
		Forum forum = forumService.getById(forumId);
		getValueStack().push(forum);
		return "addUI";
	}
	
	/**
	 * 发表主题
	 */
	public String add(){
		
		//根据forumId查询主题属于哪个版块
		Forum forum = forumService.getById(forumId);
		model.setForum(forum);		
		model.setIpAddress(getIPAddress()); 	//设置客户端的IP地址
		model.setPostTime(new Date());    //当前主题的发布时间
		model.setLastUpdateTime(model.getPostTime()); //设置最后更新时间为发布时间
		model.setReplyCount(0);         //设置当前主题的回复数为0
		model.setType(0);               //设置当前主题的类型为普通帖
		model.setAuthor(getLoginUser());        //设置主题的作者是当前登录用户
		model.setLastReply(null);  //默认没有回复
		
		topicService.save(model);
		
		return "toTopicList";
	}

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	
	
	
}
