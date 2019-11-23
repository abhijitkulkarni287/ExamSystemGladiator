package com.lti.core.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.core.entities.FileDetails;

@Repository("fileDao")
public class FileDaoImpl implements FileDao 
{
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<FileDetails> fetchFileDetails() 
	{
		List<FileDetails> fileList = new ArrayList<FileDetails>();
		String selectQueryString = "from FileDetails";
		Query selectQuery = entityManager.createQuery(selectQueryString);
		fileList=(List<FileDetails>)selectQuery.getResultList();
		return fileList;
	}

}
