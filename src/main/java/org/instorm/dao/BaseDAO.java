package org.instorm.dao;

import java.io.Serializable;   
import java.util.List;   
	// TODO 参考HibernateTemplate类重新设计该接口
public interface BaseDAO<T,ID extends Serializable> {   
    /**
     * 保存实体
     * @param entity
     */
	public ID save(T entity);
	/**
	 * 删除实体
	 * @param entity
	 */
    public void delete(T entity);
    /**
     * 根据ID删除实体
     * @param entityClass
     * @param id
     */
    public void deleteById(Class<T> entityClass,ID id);
    /**
     * 更新实体
     * @param entity
     */
    public void update(T entity);
    /**
     * 根据ID和实体类查询实体
     * @param entityClass
     * @param id
     * @return
     */
    public T findById(Class<T> entityClass,ID id);
    /**
     * 根据实体类查找所有实体
     * @param entityClass
     * @return
     */
    public List<T> findAll(Class<T> entityClass);
    /**
     * 根据sql语句查询
     * @param sql
     * @return
     */
    public List<?>findBySql(String sql);
    /**
     * 根据hql语句和条件值查询
     * @param hql
     * @param values
     * @return
     */
    public List<?> find(String hql, Object... values);
    /**
     * 分页方法,参数pagesize表示每页显示数据量，startpage表示数据库从指定开始数据读取到指定位置，
     * 例：int startpage=(当前页数-1) * pagesize;
     * 当前页数为1,pagesize为3，读取数据库0到2数据
     * 当前页数为2,pagesize为3，读取数据库3到5数据
	 */
    public List<T> find(final String hql,final int pageSize,final int startPage,final Object... values);
    /**
     * 批量删除更改实体
     * @param hql
     * @return
     */
    public int executeUpdate(final String hql);
}  
