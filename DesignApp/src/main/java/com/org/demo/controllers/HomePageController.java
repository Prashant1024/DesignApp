package com.org.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String homePage() {
		return "/designApp/home";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/error")
	public String errorPage() {
		return "error";
	}
}
