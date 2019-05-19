package cn.ustb.oa.base;

import java.util.List;

/**
 * 通用Dao接口
 * @author Lenovo
 *
 */
public interface IBaseDao<T> {
	
	/*
	 * 添加
	 */
	public void save(T entity);
	
	/*
	 * 根据id删除
	 */
	public void delete(Long id);
	
	/*
	 * 修改
	 */
	public void update(T entity);
	
	/*
	 * 根据id查询
	 */
	public T getById(Long id);
	
	/*
	 * 一次查询多个对象
	 */
	public List<T> getByIds(Long[] ids);	//导入util类
	
	/*
	 * 查询所有
	 */
	public List<T> findAll();
	
	
}
