package cn.ustb.oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.ustb.oa.base.BaseDaoImpl;
import cn.ustb.oa.dao.IReplyDao;
import cn.ustb.oa.domain.Reply;
import cn.ustb.oa.domain.Topic;

/**
 * 回复操作
 * @author Lenovo
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements IReplyDao{

	/**
	 * 根据主题查询对应的回复列表
	 */
	@Override
	public List<Reply> getReplyByTopic(Topic model) {
		
		String hql = "FROM Reply r WHERE r.topic = ? ORDER BY r.postTime ASC";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, model);
		return query.list();
	}

}
