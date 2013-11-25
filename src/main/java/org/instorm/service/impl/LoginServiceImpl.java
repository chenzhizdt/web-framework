package org.instorm.service.impl;

import java.util.List;

import org.instorm.dao.BaseDAO;
import org.instorm.model.User;
import org.instorm.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private BaseDAO baseDAO;
	
	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	@Override
	public User login(String username, String password) {
		String hql = "select User as m where m.username=? and m.password=?";
		Object[] values = new Object[2];
		values[0] = username;
		values[1] = password;
		List list = baseDAO.find(hql, values);
		if(list.iterator().hasNext()){
			return (User)list.iterator().next();
		}
		return null;
	}

}
