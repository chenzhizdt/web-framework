package org.instorm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appuser")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3960703139159808934L;
	
	public static final String MAN = "0";
	public static final String WOMAN = "1";
	
	private Integer id;
	private String username;
	private String password;
	private String nickName;
	private Date createTime;
	private Date updateTime;
	private Integer coupleId;
	private String sex;

	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public void setId(Integer id) {
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
	public Integer getCoupleId() {
		return coupleId;
	}
	public void setCoupleId(Integer coupleId) {
		this.coupleId = coupleId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
