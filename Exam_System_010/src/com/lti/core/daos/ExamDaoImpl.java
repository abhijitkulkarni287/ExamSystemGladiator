package com.lti.core.daos;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.core.entities.ExaminationDetails;
import com.lti.core.entities.FileDetails;
import com.lti.core.entities.QuestionDetails;

@Repository("examDao")
public class ExamDaoImpl implements ExamDao 
{
	@PersistenceContext
	EntityManager entityManager;
	

	public void persistAll(Object ...persistObject)
	{
		for(Object obj:persistObject) 
		{
			//entityManager.persist(obj);
		}
	}

	@Override
	public List<ExaminationDetails> fetchExamDetails() 
	{
		List<ExaminationDetails> examList = new ArrayList<ExaminationDetails>();
		String selectQueryString="from ExaminationDetails";
		Query selectQuery = entityManager.createQuery(selectQueryString);
		examList=(List<ExaminationDetails>)selectQuery.getResultList();
		return examList;
	}
	
	
}
