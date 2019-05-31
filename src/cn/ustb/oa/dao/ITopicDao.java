package cn.ustb.oa.dao;

import java.util.List;

import cn.ustb.oa.base.IBaseDao;
import cn.ustb.oa.domain.Forum;
import cn.ustb.oa.domain.Topic;

public interface ITopicDao extends IBaseDao<Topic>{

	public List<Topic> findTopicByForum(Forum model);
	
}
