package com.lti.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.core.daos.QuestionsDao;
import com.lti.core.entities.Question;
import com.lti.core.entities.QuestionDetails;
import com.lti.core.entities.QuestionOptions;

@Service("testService")
public class TestServiceImpl implements TestService {

	//Autowiring the required DAOS
	@Autowired
	QuestionsDao questionDao;
	
	@Override
	public List<Question> showQuestionList(int examId) 
	{
		List<Question> questions = new ArrayList<>();
		//Processing done for populating data into Required object which will later be converted to json
		 List<QuestionDetails>questionDetailsList=questionDao.fetchListQuestions(examId);
		
		 for(QuestionDetails q : questionDetailsList)
		 {
			 Question question = new Question();
			 question.setQuestionId(q.getQuestionId());
			 question.setQuestion(q.getQuestion());
			 question.setCorrectOption(q.getCorrectOption());
			 List<String> options = getOptionList(q.getQuestionId());
			 System.out.println("Found "+options.size()+" options");
			 question.setOptions(options);
			questions.add(question);
		 }	 
	 return questions;
	}
	
	public List<String> getOptionList(int questionId )
	{  
		List<String> options =  questionDao.fetchListOptions(questionId);
		
		return options; 
	}

}
