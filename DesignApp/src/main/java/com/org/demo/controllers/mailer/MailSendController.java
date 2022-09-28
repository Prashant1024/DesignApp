package com.org.demo.controllers.mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.demo.services.MailSendService;

@Controller
public class MailSendController {
	
	@Autowired
	MailSendService mailSendService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/sendMessage")
	@ResponseBody
	public String sendMail(@RequestParam("jsonMsg") String jsonString) {
		
		
		String returnRes = "";
		returnRes = mailSendService.sendEmail(jsonString);
		
		return returnRes;
	}
}
