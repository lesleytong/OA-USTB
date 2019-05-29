package cn.ustb.oa.dao;

import cn.ustb.oa.base.IBaseDao;
import cn.ustb.oa.domain.User;

public interface IUserDao extends IBaseDao<User>{

	public int findByLoginName(String loginName);

}
