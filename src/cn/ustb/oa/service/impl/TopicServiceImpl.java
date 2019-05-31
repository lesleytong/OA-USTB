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

	@Override
	public List<Topic> findTopicByForum(Forum model) {		
		return topicDao.findTopicByForum(model);
	}
}
