package com.lti.core.daos;

import java.util.List;

import com.lti.core.entities.FileDetails;

public interface FileDao 
{
	public List<FileDetails> fetchFileDetails();
}
