package org.instorm.dao.impl;

import java.io.Serializable;   
import java.sql.SQLException;
import java.util.List;    

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;   

import org.instorm.dao.BaseDAO;

public class BaseDAOImpl<T,ID extends Serializable> extends HibernateDaoSupport implements BaseDAO<T,ID> {   
    /**
     *  
     */
    public void delete(T entity) {   
        this.getHibernateTemplate().delete(entity);           
    }   
  
     public void deleteById(Class<T> entityClass, ID id) { 
    	//System.out.println(id+" "+entityClass);
        delete(this.findById(entityClass, id));
           
    }   
  
     public T findById(Class<T> entityClass, ID id) {   
        return this.getHibernateTemplate().get(entityClass, id);   
    }   
     
    @SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> entityClass) {   
        String name=entityClass.getName(); 
        //System.out.println(name);
        return this.getHibernateTemplate().find("from "+name);   
    }   
  
     public void save(T entity) { 
         this.getHibernateTemplate().save(entity);   
    }   
    public void update(T entity) {   
        this.getHibernateTemplate().update(entity);   
    }   
 
    public List find(String hql, Object... values) {   
        return this.getHibernateTemplate().find(hql,values);   
    }

	@SuppressWarnings("unchecked")
	public List<T> findBySql(String hql) {
		List <T>list=this.getHibernateTemplate().find(hql);
		return list;
	}   
	//执行批量更新(修改删除)
	@SuppressWarnings("unchecked")
	public int exeupdatehql(final String hql){
	    int row=0;
	    row=(Integer)getHibernateTemplate().execute(new HibernateCallback(){
	       public Object doInHibernate(Session session)throws HibernateException, SQLException {
	         Query query=session.createQuery(hql);
	         int row=query.executeUpdate();
	         return row;
	       }
	    });
	    return row;
	}
	/*分页方法,参数pagesize表示每页显示数据量，startpage表示数据库从指定开始数据读取到指定位置，
	* 例：int startpage=(当前页数-1) * pagesize;
	* 当前页数为1,pagesize为3，读取数据库0到2数据
	* 当前页数为2,pagesize为3，读取数据库3到5数据
	* */
	@SuppressWarnings("unchecked")
	public List<T> find(final String hql, final int pagesize, final int startpage,final Object... values) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().executeFind(new HibernateCallback(){
		    public Object doInHibernate(Session session)throws HibernateException, SQLException {
		      Query query=session.createQuery(hql);
		      if(values != null && values.length > 0){
		    	  for(int i = 0; i < values.length;i++){
		    		  query.setParameter(i, values[i]);
		    	  }
		      }
		      query.setFirstResult((startpage-1) * pagesize);
		      query.setMaxResults(pagesize);
		      List<T> list=query.list();
		      return list;
		    }
		 });
	}
}  

