package com.lti.web.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.lti.core.entities.FileDetails;




@RestController
@RequestMapping("file")
public class RestfulController {
	
	
	@RequestMapping(value="xyz.hr",method=RequestMethod.GET,produces="application/json")
	public String getFileDetails()
	{
		FileDetails file = new FileDetails();
		file.setFileName("def");
		file.setFileId(1);
		Gson gson = new Gson();
		return gson.toJson(file);
	}
	//@PathVariable String name
}
