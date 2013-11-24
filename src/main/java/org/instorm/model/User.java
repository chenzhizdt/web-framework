package org.instorm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_pm_user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3960703139159808934L;
	
	private String id;
	private String username;
	private String password;
	
	@Id @GeneratedValue
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
