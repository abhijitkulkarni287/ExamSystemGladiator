package com.lti.core.daos;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.core.entities.ExaminationDetails;
import com.lti.core.entities.FileDetails;
import com.lti.core.entities.QuestionDetails;

@Repository("examDao")
public class ExamDaoImpl implements ExamDao 
{
/*	@PersistenceContext
	private EntityManager entityManager;
*/
	//Insert Question details into Questions table
	@Override
	public void insertQuestionDetails(ExaminationDetails examDetails,QuestionDetails questionDetails) 
	{
		persistAll(questionDetails);
	}
	
	//Method to 
	public void persistAll(Object ...persistObject)
	{
		for(Object obj:persistObject) 
		{
			//entityManager.persist(obj);
		}
	}
	
	//For testing the methods
	public static void main(String[] args) 
	{
		
		ExaminationDetails examDetails = new ExaminationDetails(101, "java", 60, 40);
		FileDetails fileDetails = new FileDetails(1, "javaQuestions.xlsx");
		QuestionDetails questionDetails = new QuestionDetails(101, "simple language?","java",examDetails,fileDetails);
		ExamDaoImpl examDaoImpl = new ExamDaoImpl();
		examDaoImpl.insertQuestionDetails(examDetails,questionDetails);
		
	}
}
