package com.lti.web.controllers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fileUpload.hr")
public class UploadController implements ServletContextAware {
	private ServletContext context;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}
	public UploadController() {}
	
	@GetMapping
	public String home() 
	{
		return "redirect:/";	
	}
	@PostMapping
	public String upload(@RequestParam CommonsMultipartFile file,HttpServletRequest request) {
		String path = context.getRealPath("/files/");
		String filename = file.getOriginalFilename();
		//If it's not an excel file then return an error!
		if(!file.getContentType().startsWith("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return "redirect:/upload.hr?msg=incorrect+file+type";
		}
		path = path + filename;
		HttpSession session = request.getSession();
		session.setAttribute("path", path);
		try 
		{
			byte buffer[]=file.getBytes(); 
			FileOutputStream out = new FileOutputStream(path);
			out.write(buffer);
			out.close();
			return "redirect:/uploadTest.hr";	
		}
		catch(Exception ex) 
		{
			return "redirect:/?msg=Upload+failed!";
		}
		
	}
}
