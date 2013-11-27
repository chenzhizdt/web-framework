package org.instorm.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 包含一些数据访问的基础操作，具体功能说明可见{@link org.springframework.orm.hibernate3.HibernateOperations}，
 * 功能实现可以参考{@link org.springframework.orm.hibernate3.HibernateTemplate}
 * @author instorm
 *
 */
public interface BasicDAO {
	
	public <T> T get(Class<T> entityClass, Serializable id);
	
	public Object get(String entityName, Serializable id);
	
	public <T> T load(Class<T> entityClass, Serializable id);
	
	public Object load(String entityName, Serializable id);
	
	public <T> List<T> loadAll(Class<T> entityClass);
	
	public void load(Object entity, Serializable id);
	
	public Serializable save(Object entity);
	
	public Serializable save(String entityName, Object entity);
	
	public void update(Object entity);
	
	public void update(String entityName, Object entity);
	
	public void saveOrUpdate(Object entity);
	
	public void saveOrUpdate(String entityName, Object entity);
	
	public void delete(Object entity);
	
	public void delete(String entityName, Object entity);
	
	public void deleteAll(Collection entities);
	
	public List find(String queryString);
	
	public List find(String queryString, Object value);
	
	public List find(String queryString, Object... values);
	
	public List findByNamedParam(String queryString, String paramName, Object value);
	
	public List findByNamedParam(String queryString, String[] paramNames, Object[] values);
	
	public List findByValueBean(String queryString, Object valueBean);
	
	public List findByNamedQuery(String queryName);
	
	public List findByNamedQuery(String queryName, Object value);
	
	public List findByNamedQuery(String queryName, Object... values);
	
	public List findByNamedQueryAndNamedParam(String queryName, String paramName, Object value);
	
	public List findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values);
	
	public List findByNamedQueryAndValueBean(String queryName, Object valueBean);
	
	public List findByExample(Object exampleEntity);
	
	public List findByExample(String entityName, Object exampleEntity);
	
	public List findByExample(Object exampleEntity, int firstResult, int maxResults);
	
	public List findByExample(String entityName, Object exampleEntity, int firstResult, int maxResults);
}
