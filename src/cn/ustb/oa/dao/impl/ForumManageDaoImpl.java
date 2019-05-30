package cn.ustb.oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.ustb.oa.base.BaseDaoImpl;
import cn.ustb.oa.dao.IForumManageDao;
import cn.ustb.oa.domain.Forum;

/**
 * 版块管理
 * @author Lenovo
 *
 */
@Repository

public class ForumManageDaoImpl extends BaseDaoImpl<Forum> implements IForumManageDao {
	
	/**
	 * 重写父类的方法，加入保存版块时，使Position的值==id的值，这样就不会重复
	 */
	@Override
	public void save(Forum entity) {		
		super.save(entity);	//由瞬时对象变为持久对象，id已经有值
		entity.setPosition(entity.getId().intValue());
	}
	
	/**
	 * 重写查询方法，按照positon排序
	 */
	@Override
	public List<Forum> findAll() {
		String hql = "FROM Forum f ORDER BY f.position";
		return this.getSession().createQuery(hql).list();
	}

	/**
	 * 上移版块
	 */
	@Override
	public void moveUp(Long id) {		
		//select * from ustb_forum f where f.position_ < 5 order by f.position_ desc limit 0,1;
		Forum forum1 = getById(id);	//根据id查出要调整的对象
		int p1 = forum1.getPosition();
		
		String hql = "FROM Forum f WHERE f.position < ? ORDER BY f.position DESC";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, p1);
		query.setFirstResult(0);	//取结果集的第一个
		query.setMaxResults(1);		//就取一个
		Forum forum2 = (Forum) query.uniqueResult();
		
		forum1.setPosition(forum2.getPosition());
		forum2.setPosition(p1);
	}
	
	/**
	 * 下移版块
	 */
	@Override
	public void moveDown(Long id) {
		//select * from ustb_forum where position_ > 3 order by position_ limit 0,1;
		Forum forum1 = getById(id);	//根据id查出要调整的对象
		int p1 = forum1.getPosition();
		
		String hql = "FROM Forum f WHERE f.position > ? ORDER BY f.position";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, p1);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Forum forum2 = (Forum) query.uniqueResult();
		
		forum1.setPosition(forum2.getPosition());
		forum2.setPosition(p1);
	}
	
	

	
}






