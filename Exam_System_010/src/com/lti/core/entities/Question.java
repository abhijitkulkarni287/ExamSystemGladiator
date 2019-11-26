package com.lti.core.entities;

import java.util.List;

/*
 * 1)This will not be a jpa entity
 * 2)The object of this class will be populated by data from QuestionDetails
 * 	   and QuestionOptions tables
 * 3)A list consisting of these objects will be converted to a json file and sent on every REST request
 */

public class Question 
{
	//needed attributes--------------------------------------------------------------------------------------------------------------
		int questionId;
		String question;
		List<String> options;
	//needed for front end, no need to populate this
		String correctOption;
	
	//Constructors------------------------------------------------------------------------------------------------------------------------
		public Question() {}
		public Question( String question, List<String> options) {
			
			this.question = question;
			this.options = options;
		}
	//Getters and Setters---------------------------------------------------------------------------------------------------------------
		public int getQuestionId() {return questionId;}
		public void setQuestionId(int questionId){this.questionId = questionId;}
		public String getQuestion(){return question;}
		public void setQuestion(String question){this.question = question;}
		public List<String> getOptions(){return options;}
		public void setOptions(List<String> options) {this.options = options;}
		public String getCorrectOption(){return correctOption;}
		public void setCorrectOption(String selectedOption){this.correctOption = selectedOption;}
		
	
}
