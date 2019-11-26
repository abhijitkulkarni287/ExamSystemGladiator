package com.lti.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavigationController 
{
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
	public String registerStudent()
	{
		
		
		//name of page
		return null;
	}
	
	@RequestMapping("login.hr")
	public String viewLoginPage()
	{
		return "Login";
	}
	@RequestMapping(value="login.hr", method=RequestMethod.POST)
	public String loginValidator(@RequestParam("username") int id,@RequestParam("password") int password)
	{
		//check for valid user
		//if valid
		return "studentDashboard";
		//else
		//return "registration";
	}
}
