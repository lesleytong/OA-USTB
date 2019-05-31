package cn.ustb.oa.action;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ustb.oa.base.BaseAction;
import cn.ustb.oa.domain.Reply;
import cn.ustb.oa.domain.Topic;

/**
 * 回复操作
 * @author Lenovo
 *
 */
@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply>{
	
	private Long topicId;	//属性驱动，主题的id，别忘了有get和set方法

	
	/**
	 * 快速发表回复
	 * @return
	 */
	public String add() {
		
		//根据主题id查出是哪个主题
		Topic topic = topicService.getById(topicId);
		
		model.setTopic(topic);	//关联回复和主题
		model.setDeleted(0);    //默认是未删除
		model.setIpAddress(getIPAddress()); //设置客户端的IP地址
		model.setPostTime(new Date()); 		//设置回复时间为当前时间
		model.setAuthor(getLoginUser());    //设置回复人为当前登录用户
		
		replyService.save(model);
		
		return "toReplyList";	//重定向到topic/show.jsp页面（struts里面配置）
	}
	
	
	/**
	 * 点回复列表的回复链接，跳转到回复页面
	 * @return
	 */
	public String addUI() {
		
		//根据主题id查出是哪个主题
		Topic topic = topicService.getById(topicId);
		//压栈
		getValueStack().push(topic);
		
		return "addUI";
	}
	
	
	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	
}
