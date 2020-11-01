package com.service.user;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	String userId;
	String email;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
