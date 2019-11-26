package com.lti.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.lti.core.entities.Question;
import com.lti.core.entities.QuestionDetails;
import com.lti.core.entities.QuestionOptions;
import com.lti.core.services.TestService;

/*
 * Prerequisites for using gson:
 * 1)Default constructor needs to be present
 * 2)Getters and setters need to be present for every property
 * 
 * */

//This controller is written to return questions as required from test window
@RestController
@RequestMapping("test")
public class QuestionRestController 
{
	//Autowiring the required services
	@Autowired
	TestService testService;
	
	
	//we will take exam Id and return populated data
	@RequestMapping(value="fetchQuestion.hr",method=RequestMethod.GET,produces="application/json")
	public String fetchListQuestion(@RequestParam("examId") int examId)
	{		
		System.out.println(examId);
		//This will be taken from service layer
		List<Question> questionList = testService.showQuestionList(examId);
		Gson gson = new Gson();
		return gson.toJson(questionList);
	}
	
}
