package com.lti.core.services;

import java.util.List;

import com.lti.core.entities.Question;
import com.lti.core.entities.QuestionDetails;

public interface TestService 
{
	//Method to get list of questions based on examId
	public List<Question> showQuestionList(int examId);
}
