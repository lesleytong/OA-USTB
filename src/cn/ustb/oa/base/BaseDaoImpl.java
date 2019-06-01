package cn.ustb.oa.base;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.ustb.oa.domain.PageBean;
import cn.ustb.oa.utils.HQLHelper;
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

	/**
	 * 公共分页方法
	 */
	@Override
	public PageBean getPageBean(HQLHelper hh, int currentPage) {

		int pageSize = getPageSize();	//每页显示5条记录
		int firstPageResult = (currentPage - 1) * pageSize;	//当前页码从哪条记录开始显示
		
		String listHQL = hh.getListHQL();
		String countHQL = hh.getCountHQL();
		List<Object> args = hh.getArgs();
		
		Query query = this.getSession().createQuery(listHQL);	//这个还有问号，对应着args集合
		if(args!=null && args.size()>0) {
			int index = 0;
			for(Object o : args) {
				query.setParameter(index++, o);
			}
		}
		query.setFirstResult(firstPageResult);
		query.setMaxResults(pageSize);
		List recordList = query.list();	//当前页码的数据集合
		
		query = this.getSession().createQuery(countHQL);
		if(args!=null && args.size()>0) {
			int index = 0;
			for(Object o : args) {
				query.setParameter(index++, o);
			}
		}
		Long recordCount = (Long) query.uniqueResult();	//总记录数
		
		return new PageBean(currentPage, pageSize, recordCount.intValue(), recordList);
	}

	/**
	 * 读取配置文件，获取pageSize
	 * @return
	 */
	private int getPageSize() {
		
		int pageSize = 10;
		
		Properties pro = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("page.properties");
		
		try {
			pro.load(in);
			String str = (String) pro.get("pageSize");	//读取出来的是字符串类型
			pageSize = Integer.parseInt(str);
			
		} catch (IOException e) {
			pageSize = 10;
			e.printStackTrace();
		}finally {
			try {
				if(in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return pageSize;
	}
	
	


}
