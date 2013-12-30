package org.instorm.service;

import java.util.List;

import org.instorm.model.User;

public interface UserService {
	/**
	 * login method
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password);
	/**
	 * register method
	 * @param username
	 * @param password
	 * @return 0: success, 1: username error
	 */
	public int register(User user);
	/**
	 * get user info by id
	 * @param id
	 * @return
	 */
	public User getUser(Integer id);
	/**
	 * get singles
	 * @return
	 */
	public List getSingleUsers();
}
