package org.instorm.dao.impl;

import java.io.Serializable;   
import java.util.List;    

import org.hibernate.SessionFactory;
import org.instorm.dao.BaseDAO;

public class BaseDAOImpl<T,ID extends Serializable> implements BaseDAO<T,ID> {   
    /**
     *  
     */
	private SessionFactory sessionFactory;
	
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void delete(T entity) {   
//        this.getHibernateTemplate().delete(entity);
		// TODO
    }   
  
     public void deleteById(Class<T> entityClass, ID id) {
    	//System.out.println(id+" "+entityClass);
//        delete(this.findById(entityClass, id));
          // TODO 
    }   
  
     public T findById(Class<T> entityClass, ID id) {   
//        return this.getHibernateTemplate().get(entityClass, id);
    	 // TODO test
    	 return (T) this.sessionFactory.getCurrentSession().get(entityClass, id);
    }   
     
	public List<T> findAll(Class<T> entityClass) {
//        String name=entityClass.getName(); 
        //System.out.println(name);
//        return this.getHibernateTemplate().find("from "+name);
    	// TODO
        return null;
    }   
  
     public ID save(T entity) { 
//         this.getHibernateTemplate().save(entity);
    	 // TODO
    	 return null;
    }   
    public void update(T entity) {   
//        this.getHibernateTemplate().update(entity);
    	// TODO
    }   
 
    public List<?> find(String hql, Object... values) {   
//        return this.getHibernateTemplate().find(hql,values);
    	// TODO
    	return null;
    }

	public List<T> findBySql(String hql) {
//		List <T>list=this.getHibernateTemplate().find(hql);
//		return list;
		// TODO
		return null;
	}   
	//执行批量更新(修改删除)
	public int exeupdatehql(final String hql){
//	    int row=0;
//	    row=(Integer)getHibernateTemplate().execute(new HibernateCallback(){
//	       public Object doInHibernate(Session session)throws HibernateException, SQLException {
//	         Query query=session.createQuery(hql);
//	         int row=query.executeUpdate();
//	         return row;
//	       }
//	    });
//	    return row;
		// TODO
		return 0;
	}
	/*分页方法,参数pagesize表示每页显示数据量，startpage表示数据库从指定开始数据读取到指定位置，
	* 例：int startpage=(当前页数-1) * pagesize;
	* 当前页数为1,pagesize为3，读取数据库0到2数据
	* 当前页数为2,pagesize为3，读取数据库3到5数据
	* */
	public List<T> find(final String hql, final int pagesize, final int startpage,final Object... values) {
//		return getHibernateTemplate().executeFind(new HibernateCallback(){
//		    public Object doInHibernate(Session session)throws HibernateException, SQLException {
//		      Query query=session.createQuery(hql);
//		      if(values != null && values.length > 0){
//		    	  for(int i = 0; i < values.length;i++){
//		    		  query.setParameter(i, values[i]);
//		    	  }
//		      }
//		      query.setFirstResult((startpage-1) * pagesize);
//		      query.setMaxResults(pagesize);
//		      List<T> list=query.list();
//		      return list;
//		    }
//		 });
		// TODO
		return null;
	}
}  

