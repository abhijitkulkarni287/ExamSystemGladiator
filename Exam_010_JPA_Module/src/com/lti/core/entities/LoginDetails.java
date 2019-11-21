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
	@Column(name="STUDENT_ID")
	int studentId;
	@Column(name="USER_NAME")
	String userName;
	@Column(name="PASSWORD")
	String password;
	
	//Constructors
	public LoginDetails() {}
	public LoginDetails(int studentId, String userName, String password) {
		this.studentId = studentId;
		this.userName = userName;
		this.password = password;
	}
	
	//Getters and setters for attributes
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
