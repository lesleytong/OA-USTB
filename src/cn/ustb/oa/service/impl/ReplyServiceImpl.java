package cn.ustb.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ustb.oa.dao.IReplyDao;
import cn.ustb.oa.domain.Forum;
import cn.ustb.oa.domain.PageBean;
import cn.ustb.oa.domain.Reply;
import cn.ustb.oa.domain.Topic;
import cn.ustb.oa.service.IReplyService;

/**
 * 回复操作
 * @author Lenovo
 *
 */
@Service
@Transactional
public class ReplyServiceImpl implements IReplyService {
	
	@Resource
	private IReplyDao replyDao;

	/**
	 * 发表回复
	 */
	@Override
	public void save(Reply model) {
		replyDao.save(model);
		
		/*
		 * 还要进行一些维护，回复所在的版块和主题都要更新
		 */
		Forum forum = model.getTopic().getForum();	//持久对象，不用update
		forum.setArticleCount(forum.getArticleCount() + 1); 	//回复对应的版块的文章数量加1
		
		Topic topic = model.getTopic();	//持久对象，不用update
		topic.setLastUpdateTime(model.getPostTime());      //回复对应的主题的最后更新时间为当前回复发布的时间
		topic.setLastReply(model);  //主题的最后一个回复为当前回复
		topic.setReplyCount(topic.getReplyCount() + 1);    //主题的回复数量加1
		
	}
	
	
	/**
	 * 根据主题查询对应的回复列表
	 */
	@Override
	public List<Reply> getReplyByTopic(Topic model) {
		return replyDao.getReplyByTopic(model);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageBean getPageBean(int currentPage, Topic model) {
		return replyDao.getPageBean(currentPage, model);
	}
	
	
}








