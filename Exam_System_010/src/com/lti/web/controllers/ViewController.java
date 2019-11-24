package com.lti.web.controllers;

import java.util.Set;
import javax.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;

@Controller
@RequestMapping("/view-all.hr")
public class ViewController implements ServletContextAware {
	
	private ServletContext context;
		
	@GetMapping
	public String viewAll(Model model) {
		Set<String> paths = context.getResourcePaths("/images/");
		model.addAttribute("images", paths);
		return "view";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;	
	}
}
