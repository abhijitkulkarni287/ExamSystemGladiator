package com.lti.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lti.core.entities.FileDetails;

@Controller
@RequestMapping("file")
public class RestfulController {
	FileDetails file = new FileDetails();
	
	@RequestMapping(value="/{fileName}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody FileDetails getFileDetails()
	{
		file.setFileName("def");
		file.setFileId(1);
		return file;
	}
	//@PathVariable String name
}
