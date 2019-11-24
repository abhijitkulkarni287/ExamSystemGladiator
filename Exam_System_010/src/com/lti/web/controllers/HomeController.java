package com.lti.web.controllers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
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
public class HomeController implements ServletContextAware {
	private ServletContext context;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}
	
	private static Logger log = Logger.getLogger("HomeController");
	

	public HomeController() {
		log.info("Instance of Home controller created");
	}
	
	@GetMapping
	public String home() {
		log.info("Processing request 'home.htm' ");
		return "redirect:/";
		
	}
	
	@PostMapping
	public String upload(@RequestParam CommonsMultipartFile file) {
		String path = context.getRealPath("/images/");
		String filename = file.getOriginalFilename();
		//If it's not an image then return an error!
		if(!file.getContentType().startsWith("image")) {
			return "redirect:/?msg=incorrect+file+type";
		}
		path = path + filename;
		log.info("Processing file "+path);
		
		try {
			log.info("Begining file upload....");
			//NOT A GOOD IDEA, BUT A MOST SIMPLE AND SHORT
			//!!!!BEWARE: The Code may crash if file is too large!!!!
			byte buffer[]=file.getBytes(); 
			FileOutputStream out = new FileOutputStream(path);
			out.write(buffer);
			log.info("Uploading completed!");
			out.close();
			return "redirect:/fileUploadTest.hr";	
		}catch(Exception ex) {
			log.log(Level.SEVERE, ex.getMessage());
			return "redirect:/?msg=Upload+failed!";
		}
		
	}
}
