package com.lti.core.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
This entity class will store login details for every student
*/

@Entity
@Table(name="LOGIN")
@SequenceGenerator(name="testSeq", initialValue=1, allocationSize=100)
public class LoginDetails 
{
	@Id
	@SequenceGenerator(name="loginIdGen",sequenceName="loginId_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="loginIdGen")
	@Column(name="LOGIN_ID")
	private int logintId;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="USER_PASSWORD")
	private String password;
	
	//Constructors
	public LoginDetails() {}
	public LoginDetails(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	//Getters and setters for attributes
	public int getLoginId() {
		return logintId;
	}
	public void setLoginId(int loginId) {
		this.logintId = loginId;
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
