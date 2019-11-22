package com.lti.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
This entity class will store login details for every student
*/

@Entity
@Table(name="LOGIN")
public class LoginDetails 
{
	@Id
	@Column(name="LOGIN_ID")
	int loginId;
	@Column(name="USER_NAME")
	String userName;
	@Column(name="PASSWORD")
	String password;
	
	//Constructors
	public LoginDetails() {}
	public LoginDetails(int loginId, String userName, String password) {
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
	}
	
	//Getters and setters for attributes
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
