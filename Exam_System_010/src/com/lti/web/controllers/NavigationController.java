package com.lti.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.core.entities.LoginDetails;
import com.lti.core.entities.StudentDetails;
import com.lti.core.services.StudentService;

@Controller
public class NavigationController 
{
	@Autowired
	StudentService studentService;
	
	@RequestMapping("home.hr")
	public String homePage() {
		return "home";
	}
	@RequestMapping("register.hr")
	public String viewRegisterPage()
	{
		return "RegistrationPage";
	}
	@RequestMapping("registerStudent.hr")
	public String registerStudent(@RequestParam("username")String username,@RequestParam("password")String password,StudentDetails student)
	{
		LoginDetails login = new LoginDetails();
		login.setUserName(username);
		login.setPassword(password);
		studentService.insertStudentDetails(student, login);
		return "Login";
	}
	
	@RequestMapping("login.hr")
	public String viewLoginPage()
	{
		return "Login";
	}
	@RequestMapping(value="loginValidate.hr")
	public String loginValidator(@RequestParam("username") String username,@RequestParam("password") String password)
	{ 
		if(studentService.validateLogin(username, password))
			return "StudentDashboard";
		return "Login";
	}
}
