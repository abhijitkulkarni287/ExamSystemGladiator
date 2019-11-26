package com.lti.core.services;

import java.util.List;

import com.lti.core.entities.ExaminationDetails;
import com.lti.core.entities.FileDetails;

/*
 * Provides service for admin operations of adding and deleting questions
 */
public interface AdminQuestionService 
{
	//Methods for adding and deleting questions
	public void addQuestionsFromFile(String path,String fileName);
	public void removeQuestionsFromFile(String fileName);
	
	//Methods for returning lists
	public List<ExaminationDetails> showExamList();
	public List<FileDetails> showFileList();
}
