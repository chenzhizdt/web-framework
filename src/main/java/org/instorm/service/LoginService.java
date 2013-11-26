package org.instorm.service;

import org.instorm.model.User;

public interface LoginService {
	public User login(String username, String password);
	public User findById(String id);
}
