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
		//select * from ustb_topic order by (case type when 2 then 2 else 1 end) desc, postTime desc;
		String hql = "FROM Topic t WHERE t.forum = ? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 1 END) DESC, t.postTime DESC";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, model);
		return query.list();
	}

}
