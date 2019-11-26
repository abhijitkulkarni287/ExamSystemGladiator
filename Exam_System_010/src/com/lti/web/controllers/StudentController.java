package com.lti.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//For managing exam
	@RequestMapping("examManager.hr")
	public ModelAndView manageExam(@RequestParam("examId") int examId)
	{
		//to identify which subject to fetch questions f
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("examId", examId);
		mAndV.setViewName("TestWindow");
		return mAndV;
	}
	
	//for submitting test and taking result
	
}
