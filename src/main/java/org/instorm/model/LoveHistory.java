package org.instorm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lovehistory")
public class LoveHistory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1227108725322179558L;
	private Integer id;
	private String content;
	private Date createTime;
	private Integer coupleId;
	private Integer createUserId;
	private String createName;
	
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getCoupleId() {
		return coupleId;
	}
	public void setCoupleId(Integer coupleId) {
		this.coupleId = coupleId;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	
}
