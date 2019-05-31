package cn.ustb.oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.ustb.oa.base.BaseDaoImpl;
import cn.ustb.oa.dao.ITopicDao;
import cn.ustb.oa.domain.Forum;
import cn.ustb.oa.domain.Topic;

/**
 * 主题操作
 * @author Lenovo
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements ITopicDao{

	/**
	 * 根据版块查询主题列表
	 */
	@Override
	public List<Topic> findTopicByForum(Forum model) {
		
		String hql = "FROM Topic t WHERE t.forum = ?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, model);
		return query.list();
	}

}
