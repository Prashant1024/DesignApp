package com.org.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/error")
	public String errorPage() {
		return "error";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/contactUs")
	public String contactUsPage() {
		return "contact";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/services")
	public String servicePage() {
		return "services";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/working")
	public String workingPage() {
		return "working";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/aboutUs")
	public String aboutUsPage() {
		return "aboutUs";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/projects")
	public String projectsPage() {
		return "projects";
	}

}
