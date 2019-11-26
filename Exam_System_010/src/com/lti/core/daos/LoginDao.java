package com.lti.core.daos;

import java.util.List;

import com.lti.core.entities.LoginDetails;

public interface LoginDao 
{
	public List<LoginDetails> getLogin();
}
