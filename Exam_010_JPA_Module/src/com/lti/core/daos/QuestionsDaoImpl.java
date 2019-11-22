package com.lti.core.daos;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.core.entities.ExaminationDetails;
import com.lti.core.entities.FileDetails;
import com.lti.core.entities.QuestionDetails;

public class QuestionsDaoImpl implements QuestionsDao 
{
	
	@Autowired
	EntityManager entityManager;
	
	public void persistAll(Object ...persistObject)
	{
		for(Object obj:persistObject) 
		{
			entityManager.persist(obj);
		}
	}
	
	@Override
	public void insertQuestions(ExaminationDetails examDetails,FileDetails fileDetails, QuestionDetails questionDetails) 
	{
		questionDetails.setExam(examDetails);
		questionDetails.setFileDetails(fileDetails);
		persistAll(examDetails,fileDetails,questionDetails);
	}

	@Override
	public void deleteQuestions(String fileName) 
	{
		String selectQueryString="SELECT f.fileId FROM FileDetails f WHERE f.fileName=?1";
		Query selectQuery = entityManager.createQuery(selectQueryString);
		selectQuery.setParameter(1, fileName);
		
		int fid = Integer.parseInt(selectQuery.getSingleResult().toString());
		
		//IMP
		String updateQueryString="UPDATE QuestionDetails q SET q.deleted='YES' WHERE q.fileDetails.fileId=?1";
		Query updateQuery=entityManager.createQuery(updateQueryString);
		updateQuery.setParameter(1, fid);
		updateQuery.executeUpdate();
	}

}
