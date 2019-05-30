package cn.ustb.oa.dao;

import cn.ustb.oa.base.IBaseDao;
import cn.ustb.oa.domain.Forum;

public interface IForumManageDao extends IBaseDao<Forum>{

	public void moveUp(Long id);

	public void moveDown(Long id);

}
