package org.instorm.service.impl;

import java.util.Date;
import java.util.List;

import org.instorm.dao.BasicDAO;
import org.instorm.model.User;
import org.instorm.service.UserService;
import org.instorm.utils.DataCheck;

public class UserServiceImpl implements UserService{
	
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
	public int register(User user) {
		String hql = "from User as m where m.username = ?";
		List list = basicDAO.find(hql, new Object[]{user.getUsername()});
		if(list.iterator().hasNext()){
			return 1;
		}
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		basicDAO.save(user);
		return 0;
	}

	@Override
	public User getUser(Integer id) {
		String hql = "from User as m where m.id = ?";
		List list = basicDAO.find(hql, new Object[]{id});
		if(list.iterator().hasNext()){
			return (User)list.iterator().next();
		}
		return null;
	}

	@Override
	public List getSingleUsers() {
		String hql = "from User as m where m.coupleId is null";
		return basicDAO.find(hql);
	}
}
