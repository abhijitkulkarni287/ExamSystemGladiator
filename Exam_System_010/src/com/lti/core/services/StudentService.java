package com.lti.core.services;

import java.util.List;

import com.lti.core.entities.LoginDetails;
import com.lti.core.entities.StudentDetails;

public interface StudentService 
{
	public void insertStudentDetails(StudentDetails student,LoginDetails login);
	public Boolean validateLogin(String username,String password);
}
