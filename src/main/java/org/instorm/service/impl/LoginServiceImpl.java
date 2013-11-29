package org.instorm.service.impl;

import java.util.List;

import org.instorm.dao.BasicDAO;
import org.instorm.model.User;
import org.instorm.service.LoginService;
import org.instorm.utils.DataCheck;

public class LoginServiceImpl implements LoginService {

	private BasicDAO basicDAO;

	public BasicDAO getBasicDAO() {
		return basicDAO;
	}

	public void setBasicDAO(BasicDAO basicDAO) {
		this.basicDAO = basicDAO;
	}

	@Override
	public User login(String username, String password) {
		String hql = "from User as m where m.username=? and m.password=?";
		if(!DataCheck.isNullOrBlank(username) && !DataCheck.isNullOrBlank(password)){
			List list = basicDAO.find(hql, new Object[]{username, password});
			if(list.iterator().hasNext()){
				return (User)list.iterator().next();
			}
		}
		return null;
	}

	@Override
	public User findById(String id) {
		return (User) basicDAO.get(User.class, id);
	}

}
