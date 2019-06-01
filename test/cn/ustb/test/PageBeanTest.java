package cn.ustb.test;

import cn.ustb.oa.domain.PageBean;

public class PageBeanTest {

	public static void main(String[] args) {
		PageBean pb = new PageBean(28, 10, 300, null);
		System.out.println("总页数："+pb.getPageCount());
		System.out.println("开始索引：" + pb.getBeginPageIndex());
		System.out.println("结束索引：" + pb.getEndPageIndex());
	}
}
