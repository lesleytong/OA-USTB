package cn.ustb.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ustb.oa.dao.ITopicDao;
import cn.ustb.oa.domain.Forum;
import cn.ustb.oa.domain.Topic;
import cn.ustb.oa.service.ITopicService;
/**
 * 主题操作
 * @author Lenovo
 *
 */
@Service
@Transactional
public class TopicServiceImpl implements ITopicService {
	
	@Resource
	private ITopicDao topicDao;

	/**
	 * 根据版块查找主题列表
	 */
	@Override
	public List<Topic> findTopicByForum(Forum model) {		
		return topicDao.findTopicByForum(model);
	}
	
	
	/**
	 * 发表主题
	 */
	@Override
	public void save(Topic model) {
		
		topicDao.save(model);  //主题model为持久对象了
		Forum forum = model.getForum(); //根据主题model查出的forum也是持久对象
		
		forum.setTopicCount(forum.getTopicCount() + 1);	    //当前主题所在的版块的主题数量+1
		forum.setArticleCount(forum.getArticleCount() + 1); //当前主题所在的版块的文章数量+1
		forum.setLastTopic(model);  //设置版块的最后发表主题为当前主题
		
	}

	/**
	 * 根据id查询是哪个主题
	 */
	@Override
	public Topic getById(Long id) {		
		return topicDao.getById(id);
	}
	
}







