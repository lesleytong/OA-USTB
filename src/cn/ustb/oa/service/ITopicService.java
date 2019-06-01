package cn.ustb.oa.service;

import java.util.List;

import cn.ustb.oa.domain.Forum;
import cn.ustb.oa.domain.PageBean;
import cn.ustb.oa.domain.Topic;
import cn.ustb.oa.utils.HQLHelper;

public interface ITopicService {

	public List<Topic> findTopicByForum(Forum model);

	public void save(Topic model);

	public Topic getById(Long id);

	public PageBean getPageBean(HQLHelper hh, int currentPage);

}
