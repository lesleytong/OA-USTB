package cn.ustb.oa.service;

import java.util.List;

import cn.ustb.oa.domain.Book;

public interface IBookService {

	/*
	 * 添加
	 */
	public void save(Book book);
	
	/*
	 * 根据id删除
	 */
	public void delete(Long id);
	
	/*
	 * 修改
	 */
	public void update(Book book);
	
	/*
	 * 根据id查询
	 */
	public Book getById(Long id);
	
	/*
	 * 一次查询多个对象
	 */
	public List<Book> getByIds(Long[] ids);	//导入util类
	
	/*
	 * 查询所有
	 */
	public List<Book> findAll();
}
