package com.lti.core.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.core.entities.LoginDetails;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<LoginDetails> getLogin() 
	{
		List<LoginDetails> loginList = new ArrayList<LoginDetails>();
		String loginQueryString = "from LoginDetails";
		Query loginQuery = entityManager.createQuery(loginQueryString);
		loginList = loginQuery.getResultList();
		return loginList;
	}

}
