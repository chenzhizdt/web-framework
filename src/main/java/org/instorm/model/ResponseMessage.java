package org.instorm.model;

public class ResponseMessage {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private int status;
	private String message;
	private Object item;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getItem() {
		return item;
	}
	public void setItem(Object item) {
		this.item = item;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
