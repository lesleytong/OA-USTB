package cn.ustb.oa.dao.impl;

import org.springframework.stereotype.Repository;

import cn.ustb.oa.base.BaseDaoImpl;
import cn.ustb.oa.dao.IUserDao;
import cn.ustb.oa.domain.User;

/**
 * 用户管理
 * @author Lenovo
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{

	/**
	 * 根据登录名统计有多少相同的用户
	 */
	@Override
	public int findByLoginName(String loginName) {
		
		String hql = "SELECT COUNT(id) FROM User u WHERE u.loginName=?";
		Long count = (Long) this.getSession().createQuery(hql).setParameter(0, loginName).uniqueResult();
		return count.intValue();
	}

}
