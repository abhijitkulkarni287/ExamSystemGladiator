package com.lti.core.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.core.entities.LoginDetails;
import com.lti.core.entities.StudentDetails;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao
{
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void insertStudentDetails(StudentDetails student, LoginDetails login) {
		student.setLogin(login);
		entityManager.persist(login);
		entityManager.persist(student);
	}

}
