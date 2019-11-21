package com.lti.core.daos;

import com.lti.core.entities.ExaminationDetails;
import com.lti.core.entities.QuestionDetails;

public interface ExamDao 
{
	//this method will insert question details into the Questions table	
	public void insertQuestionDetails(ExaminationDetails examDetails,QuestionDetails questionDetails);

}
