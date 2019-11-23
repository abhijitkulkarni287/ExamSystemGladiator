package com.lti.core.daos;

import java.util.List;

import com.lti.core.entities.ExaminationDetails;
import com.lti.core.entities.FileDetails;
import com.lti.core.entities.QuestionDetails;
import com.lti.core.entities.QuestionOptions;

/*
 * Questions Dao Interface
 * 
 * */

public interface QuestionsDao 
{
	
	//1)Upload use case
	//method to insert question details
	public void insertQuestions(ExaminationDetails examDetails,FileDetails fileDetails,List<QuestionDetails> questionList,List<QuestionOptions> optionList);
	
	//2) Delete use case
	public void deleteQuestions(String fileName);

}
