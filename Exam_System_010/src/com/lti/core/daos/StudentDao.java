package com.lti.core.daos;

import com.lti.core.entities.LoginDetails;
import com.lti.core.entities.StudentDetails;

public interface StudentDao 
{
	public void insertStudentDetails(StudentDetails student,LoginDetails login);
}
