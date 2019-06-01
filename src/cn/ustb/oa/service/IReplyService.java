package cn.ustb.oa.service;

import java.util.List;

import cn.ustb.oa.domain.PageBean;
import cn.ustb.oa.domain.Reply;
import cn.ustb.oa.domain.Topic;
import cn.ustb.oa.utils.HQLHelper;

public interface IReplyService {

	public void save(Reply model);

	public List<Reply> getReplyByTopic(Topic model);

	public PageBean getPageBean(HQLHelper hh, int currentPage);

}
