package cn.ustb.oa.dao;

import java.util.List;

import cn.ustb.oa.base.IBaseDao;
import cn.ustb.oa.domain.Reply;
import cn.ustb.oa.domain.Topic;

public interface IReplyDao extends IBaseDao<Reply>{

	public List<Reply> getReplyByTopic(Topic model);

}
