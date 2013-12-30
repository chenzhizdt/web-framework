package org.instorm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pet")
public class Pet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7759645959433621145L;
	private Integer id;
	private String name;
	private Integer heartIndex;
	private String type;
	private Integer coupleId;
	
	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHeartIndex() {
		return heartIndex;
	}
	public void setHeartIndex(Integer heartIndex) {
		this.heartIndex = heartIndex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCoupleId() {
		return coupleId;
	}
	public void setCoupleId(Integer coupleId) {
		this.coupleId = coupleId;
	}
	
}
