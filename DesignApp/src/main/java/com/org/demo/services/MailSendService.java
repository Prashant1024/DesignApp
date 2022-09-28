package com.org.demo.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.org.demo.util.MailUtil;

@Service
public class MailSendService {

	@Autowired
	JavaMailSender javaMailSender;

	public String sendEmail(String jsonString){
		String returnRes = "1";
		
		JSONObject params = new JSONObject(jsonString);
		
		String fromMailId = params.optString("email");
		String toMailId = MailUtil.toEmail;
		String message = params.optString("message");
		String subject = MailUtil.emailSubject;
		String name = params.optString("name");
		String content = "Hi, This mail is from "+name+" .";
		content += message;
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(fromMailId);
			mimeMessageHelper.setTo(toMailId);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(content, true);
			mimeMessageHelper.setSentDate(new Date());
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			returnRes = "0";
		}

		return returnRes;
	}
	
	
	
}
