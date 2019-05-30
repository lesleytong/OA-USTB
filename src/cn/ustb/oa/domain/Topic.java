package cn.ustb.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Topic extends Article {
	private String title;	//标题
	private Date lastUpdateTime;	//最后更新时间
	private int type;	//主题的类型
	private Forum forum;	//当前主题属于哪个版块
	private Set<Reply> replies = new HashSet<Reply>();	//当前主题对应的回复集合
	private int replyCount;	//当前主题对应的回复数量
	private Reply lastReply;	//当前主题对应的最新回复
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public Set<Reply> getReplies() {
		return replies;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public Reply getLastReply() {
		return lastReply;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}
	
	
}
