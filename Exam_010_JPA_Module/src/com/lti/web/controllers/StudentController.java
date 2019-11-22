package com.lti.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lti.core.entities.ExaminationDetails;
import com.lti.core.services.AdminQuestionService;

//https://localhost:8082/
@Controller
public class StudentController 
{
	@Autowired
	AdminQuestionService service;
	
	@RequestMapping("viewexamlist.hr")
	public ModelAndView showExamList()
	{
		List<ExaminationDetails> examList = service.showExamList();
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("examList", examList);
		String jspName="ViewExamList";
		mAndV.setViewName(jspName);
		return mAndV;
	}
	
	
	
}
