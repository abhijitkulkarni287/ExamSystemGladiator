package com.lti.web.controllers;

import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lti.core.entities.ExaminationDetails;
import com.lti.core.entities.FileDetails;
import com.lti.core.services.AdminQuestionService;

@Controller
public class AdminController 
{
	@Autowired
	AdminQuestionService adminService;
	
	@RequestMapping("upload.hr")
	public ModelAndView showExamList()
	{
		List<ExaminationDetails> examList = adminService.showExamList();
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("examList", examList);
		String jspName="Upload";
		mAndV.setViewName(jspName);
		return mAndV;
	}
	
	
	/*
	 *	This should return a list of file names to be shown to the 
	 *	admin from which he will select a file to be deleted. 
	 *	
	 */
	@RequestMapping(value="delete.hr")
	public ModelAndView getFileList()
	{
		List<FileDetails> fileList = adminService.showFileList();
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("fileList", fileList);
		String jspName="Delete";
		mAndV.setViewName(jspName);
		return mAndV;
	}
	
	@RequestMapping(value="deleteFile.hr")
	public ModelAndView deleteFile()
	{
		List<ExaminationDetails> examList = adminService.showExamList();
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("examList", examList);
		String jspName="Upload";
		mAndV.setViewName(jspName);
		return mAndV;
	}
	

}
