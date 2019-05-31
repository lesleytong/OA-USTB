package cn.ustb.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ustb.oa.base.BaseDaoImpl;
import cn.ustb.oa.dao.IForumDao;
import cn.ustb.oa.domain.Forum;

/**
 * 参与版块操作
 * @author zhaoqx
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class ForumDaoImpl extends BaseDaoImpl<Forum> implements IForumDao{
	
	/**
	 * 查询板块列表，按照position属性进行排序
	 */
	@Override
	public List<Forum> findAll() {
		String hql = "FROM Forum f ORDER BY f.position";
		return this.getSession().createQuery(hql).list();
	}

}
