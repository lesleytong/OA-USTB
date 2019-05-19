package cn.ustb.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/*
 * 通用的Dao实现
 */
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements IBaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	
	
	public Session getSession(){
		//getCurrentSession方法创建的Session实例会被绑定到当前线程中，
		//它在提交或回滚操作时会自动关闭。
		return sessionFactory.getCurrentSession();
	}
	
	public BaseDaoImpl() {
		//获得实体类型
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();//获得真正的父类
		Type[] types = genericSuperclass.getActualTypeArguments();
		clazz = (Class<T>) types[0];
	}
	
	public void save(T entity) {
		getSession().save(entity);
	}
	
	public void delete(Long id) {
		getSession().delete(getSession().get(clazz, id));
	}
	
	public void update(T entity) {
		getSession().update(entity);
	}

	public List<T> findAll() {
		//createQuery()方法用于数据库操作对象
		//HQL语法很像SQL，但它是完全面向对象的。
		String hql = "FROM " + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

	public T getById(Long id) {
		return (T) getSession().get(clazz, id);
	}
	
	public List<T> getByIds(Long[] ids) {
		String hql = "FROM " + clazz.getSimpleName() + " WHERE id in (:ids)";
		Query query = getSession().createQuery(hql);
		query.setParameterList("ids", ids);//一次赋值多个
		return query.list();
	}


}
