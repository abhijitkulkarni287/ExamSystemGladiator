package com.lti.core.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.core.entities.ExaminationDetails;
import com.lti.core.entities.FileDetails;
import com.lti.core.entities.Question;
import com.lti.core.entities.QuestionDetails;
import com.lti.core.entities.QuestionOptions;

@Repository("questionDao")
public class QuestionsDaoImpl implements QuestionsDao 
{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void persistAll(Object ...persistObject)
	{
		for(Object obj:persistObject) 
		{
			entityManager.persist(obj);
		}
	}
	
	@Override
	public void insertQuestions(ExaminationDetails examDetails,FileDetails fileDetails,List<QuestionDetails> questionList,List<QuestionOptions> optionList) 
	{
		for(QuestionDetails q:questionList)
		{
			//q.setExam(examDetails);
			//q.setFileDetails(fileDetails);
			persistAll(examDetails,fileDetails,q);		
		}
		for(QuestionOptions o:optionList)
		{
			entityManager.persist(o);
		}	
	}

	@Override
	public void deleteQuestions(String fileName) 
	{
		String selectQueryString="SELECT f.fileId FROM FileDetails f WHERE f.fileName=?1";
		Query selectQuery = entityManager.createQuery(selectQueryString);
		selectQuery.setParameter(1, fileName);
		
		int fid = Integer.parseInt(selectQuery.getSingleResult().toString());
		System.out.println(fid);
		System.out.println(fileName);
		//IMP
		String updateQueryString="UPDATE QuestionDetails q SET q.deleted='YES' WHERE q.fileDetails.fileId=?1";
		Query updateQuery=entityManager.createQuery(updateQueryString);
		updateQuery.setParameter(1, fid);
		updateQuery.executeUpdate();
		
		//FileDetails fileDetails = entityManager.find(FileDetails.class, fid);
		//entityManager.remove(fileDetails);
	}
	
	
	@Override
	public List<QuestionDetails> fetchListQuestions(int examId)
	{
		String questionQueryString = "from QuestionDetails qd where qd.exam.examId=?1 and qd.deleted=null";
		Query questionQuery = entityManager.createQuery(questionQueryString);
		questionQuery.setParameter(1, examId);
		List<QuestionDetails> questionList = (List<QuestionDetails>)questionQuery.getResultList();
		return questionList;
	}
	
	//will return list of options 
		@Override
		public List<String> fetchListOptions(int questionId)
		{
			String questionQueryString = "select q0.option from QuestionOptions q0 where q0.questionDetails.questionId=?1";
			TypedQuery<String> questionQuery = entityManager.createQuery(questionQueryString,String.class);
			questionQuery.setParameter(1, questionId);			
			return questionQuery.getResultList();
		}
	
	
	

}
