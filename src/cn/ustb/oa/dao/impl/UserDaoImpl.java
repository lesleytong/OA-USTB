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

}
