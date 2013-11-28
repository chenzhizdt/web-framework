package org.instorm.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.instorm.dao.BasicDAO;

public class BasicDAOImpl implements BasicDAO{
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public <T> T get(Class<T> entityClass, Serializable id) {
		return (T) this.sessionFactory.getCurrentSession().get(entityClass, id);
	}

	@Override
	public Object get(String entityName, Serializable id) {
		return this.sessionFactory.getCurrentSession().get(entityName, id);
	}

	@Override
	public <T> T load(Class<T> entityClass, Serializable id) {
		return (T) this.sessionFactory.getCurrentSession().load(entityClass, id);
	}

	@Override
	public Object load(String entityName, Serializable id) {
		return this.sessionFactory.getCurrentSession().load(entityName, id);
	}

	@Override
	public <T> List<T> loadAll(Class<T> entityClass) {
		return this.sessionFactory.getCurrentSession().createCriteria(entityClass).list();
	}

	@Override
	public void load(Object entity, Serializable id) {
		this.sessionFactory.getCurrentSession().load(entity, id);
	}

	@Override
	public Serializable save(Object entity) {
		return this.sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public Serializable save(String entityName, Object entity) {
		return this.sessionFactory.getCurrentSession().save(entityName, entity);
	}

	@Override
	public void update(Object entity) {
		this.sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void update(String entityName, Object entity) {
		this.sessionFactory.getCurrentSession().update(entityName, entity);
	}

	@Override
	public void saveOrUpdate(Object entity) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdate(String entityName, Object entity) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(entityName, entity);
	}

	@Override
	public void delete(Object entity) {
		this.sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public void delete(String entityName, Object entity) {
		this.sessionFactory.getCurrentSession().delete(entityName, entity);
	}

	@Override
	public void deleteAll(Collection entities) {
		Session session = this.sessionFactory.getCurrentSession();
		for(Object entity:entities){
			session.delete(entity);
		}
	}

	@Override
	public List find(String queryString) {
		return find(queryString, new Object[]{null});
	}

	@Override
	public List find(String queryString, Object value) {
		return find(queryString, new Object[]{value});
	}

	@Override
	public List find(String queryString, Object... values) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		if(values != null && values.length > 0){
			for(int i = 0; i < values.length; i++){
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	@Override
	public List findByNamedParam(String queryString, String paramName,
			Object value) {
		return findByNamedParam(queryString, new String[]{paramName}, new Object[]{value});
	}

	@Override
	public List findByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		if(paramNames != null && values != null && paramNames.length > 0 && paramNames.length == values.length){
			for(int i = 0; i < paramNames.length; i++){
				query.setParameter(paramNames[i], values[i]);
			}
			return query.list();
		}
		return null;
	}

	@Override
	public List findByValueBean(String queryString, Object valueBean) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		query.setProperties(valueBean);
		return query.list();
	}

	@Override
	public List findByNamedQuery(String queryName) {
		return findByNamedQuery(queryName, (Object[]) null);
	}

	@Override
	public List findByNamedQuery(String queryName, Object value) {
		return findByNamedQuery(queryName, new Object[] {value});
	}

	@Override
	public List findByNamedQuery(String queryName, Object... values) {
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery(queryName);
		if(values != null && values.length > 0){
			for(int i = 0; i < values.length; i++){
				query.setParameter(i, values[i]);
			}
			return query.list();
		}
		return null;
	}

	@Override
	public List findByNamedQueryAndNamedParam(String queryName,
			String paramName, Object value) {
		return findByNamedQueryAndNamedParam(queryName, new String[] {paramName}, new Object[] {value});
	}

	@Override
	public List findByNamedQueryAndNamedParam(String queryName,
			String[] paramNames, Object[] values) {
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery(queryName);
		if(paramNames != null && values != null && paramNames.length > 0 && paramNames.length == values.length){
			for(int i = 0; i < paramNames.length; i++){
				query.setParameter(paramNames[i], values[i]);
			}
			return query.list();
		}
		return null;
	}

	@Override
	public List findByNamedQueryAndValueBean(String queryName, Object valueBean) {
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery(queryName);
		query.setProperties(valueBean);
		return query.list();
	}

	@Override
	public List findByExample(Object exampleEntity) {
		return findByExample(null, exampleEntity, -1, -1);
	}

	@Override
	public List findByExample(String entityName, Object exampleEntity) {
		return findByExample(entityName, exampleEntity, -1, -1);
	}

	@Override
	public List findByExample(Object exampleEntity, int firstResult,
			int maxResults) {
		return findByExample(null, exampleEntity, firstResult, maxResults);
	}

	@Override
	public List findByExample(String entityName, Object exampleEntity,
			int firstResult, int maxResults) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria executableCriteria = (entityName != null ?
				session.createCriteria(entityName) : session.createCriteria(exampleEntity.getClass()));
		executableCriteria.add(Example.create(exampleEntity));
		if (firstResult >= 0) {
			executableCriteria.setFirstResult(firstResult);
		}
		if (maxResults > 0) {
			executableCriteria.setMaxResults(maxResults);
		}
		return executableCriteria.list();
	}

}
