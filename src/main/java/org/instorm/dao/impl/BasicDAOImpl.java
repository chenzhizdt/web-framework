package org.instorm.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.instorm.dao.BasicDAO;

public class BasicDAOImpl implements BasicDAO{

	@Override
	public <T> T get(Class<T> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(String entityName, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T load(Class<T> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object load(String entityName, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> loadAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load(Object entity, Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Serializable save(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(String entityName, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String entityName, Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(String entityName, Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String entityName, Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Collection entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List find(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List find(String queryString, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List find(String queryString, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByNamedParam(String queryString, String paramName,
			Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByValueBean(String queryString, Object valueBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByNamedQuery(String queryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByNamedQuery(String queryName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByNamedQuery(String queryName, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByNamedQueryAndNamedParam(String queryName,
			String paramName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByNamedQueryAndNamedParam(String queryName,
			String[] paramNames, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByNamedQueryAndValueBean(String queryName, Object valueBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByExample(Object exampleEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByExample(String entityName, Object exampleEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByExample(Object exampleEntity, int firstResult,
			int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByExample(String entityName, Object exampleEntity,
			int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

}
