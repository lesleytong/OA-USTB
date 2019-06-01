package cn.ustb.oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.ustb.oa.base.BaseDaoImpl;
import cn.ustb.oa.dao.IReplyDao;
import cn.ustb.oa.domain.PageBean;
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

	/**
	 * 分页查询
	 */
	@Override
	public PageBean getPageBean(int currentPage, Topic model) {
		
		int pageSize = 5;
		int firstResult = (currentPage - 1) * pageSize;
		String hql = "FROM Reply r WHERE r.topic = ? ORDER BY r.postTime ASC";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, model);
		query.setFirstResult(firstResult);	//本页从哪条数据开始查
		query.setMaxResults(pageSize);	//本页查询多少数据
		List recordList = query.list();	//recordList是页面要显示的数据集合
		
		hql = "SELECT COUNT(id) FROM Reply r WHERE r.topic = ?";
		query = this.getSession().createQuery(hql);
		query.setParameter(0, model);
		Long recordCount = (Long) query.uniqueResult();	//总记录数
		
		return new PageBean(currentPage, pageSize, recordCount.intValue(), recordList);
	}

}
