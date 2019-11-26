package com.lti.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.core.daos.LoginDao;
import com.lti.core.daos.StudentDao;
import com.lti.core.entities.LoginDetails;
import com.lti.core.entities.StudentDetails;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	@Autowired
	LoginDao loginDao;
	
	@Override
	@Transactional
	public void insertStudentDetails(StudentDetails student, LoginDetails login) 
	{
		studentDao.insertStudentDetails(student,login);
		
	}


	@Override
	public Boolean validateLogin(String username,String password) {
		List<LoginDetails>loginList=loginDao.getLogin();
		for(LoginDetails ld:loginList)
		{
			if(ld.getUserName().equals(username)&&ld.getPassword().equals(password))
				return true;
			
		}
		return false;
	}

}
