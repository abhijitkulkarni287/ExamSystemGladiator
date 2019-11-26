package com.lti.core.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
Student Details are stored in this entity whenever a new student registers
from the registration page
*/

@Entity
@Table(name="STUDENT")
public class StudentDetails 
{
	//Attributes for the entity
	@Id
	@SequenceGenerator(name="studentIdGen",sequenceName="studentId_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="studentIdGen")
	@Column(name="STUDENT_ID")
	private int studentId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="DOB")
	private String dateOfBirth;
	@Column(name="GENDER")
	private String gender;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PHONE")
	private String phoneNumber;
	@Column(name="CITY")
	private String city;
	@Column(name="STUDENT_STATE")
	private String state;
	
	//Association Mapping
	@OneToOne( cascade=CascadeType.ALL)
	@JoinColumn(name="LOGIN_ID")
	private LoginDetails login;
	
	//Constructors
	public StudentDetails() {}
	public StudentDetails(String firstName, String lastName, String dateOfBirth, String gender,String email, String phoneNumber, String city, String state,LoginDetails login) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.state = state;
		this.login = login;
	}
	
	//Getters and Setters for the attributes
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LoginDetails getLogin() {
		return login;
	}
	public void setLogin(LoginDetails login) {
		this.login = login;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}	

}
