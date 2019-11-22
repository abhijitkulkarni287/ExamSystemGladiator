package com.lti.core.daos;

import com.lti.core.entities.ExaminationDetails;
import com.lti.core.entities.FileDetails;
import com.lti.core.entities.QuestionDetails;

/*
 * Questions Dao Interface
 * 
 * */

public interface QuestionsDao 
{
	
	//1)Upload use case
	//method to insert question details
	public void insertQuestions(ExaminationDetails examDetails,FileDetails fileDetails,QuestionDetails questionDetails);
	
	//2) Delete use case
	public void deleteQuestions(String fileName);

}
