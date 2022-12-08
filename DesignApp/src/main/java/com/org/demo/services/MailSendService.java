package com.org.demo.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.org.demo.util.MailUtil;

@Service
public class MailSendService {

	@Autowired
	JavaMailSender javaMailSender;

	public String sendEmail(String jsonString) throws UnsupportedEncodingException{
		String returnRes = "1";
		
		JSONObject params = new JSONObject(jsonString);
		
		String toMailId = params.optString("email");
		String fromMailId = MailUtil.toEmail;
		String message = params.optString("message");
		String subject = MailUtil.emailSubject;
		String name = params.optString("name");
		
		String phone = params.optString("phone");
		
		String content = MailUtil.getEmailContent(message, name);
				
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(fromMailId, MailUtil.mailName);
			mimeMessageHelper.setTo(toMailId);
			mimeMessageHelper.setSubject(subject);
			
			content += "<hr><img src='cid:logoImage'/>"
					+"<p style='color:#fff; font-size:14px;'>Aren Studio - Turnkey Interior Solutions</p>";
			
			content += "</div>";
			
			mimeMessageHelper.setText(content, true);
			mimeMessageHelper.setSentDate(new Date());
			
			ClassPathResource resource = new ClassPathResource("/static/img/ALogo.png");
			mimeMessageHelper.addInline("logoImage", resource);
			
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			returnRes = "0";
		}
		
		
		//Sending mail to Aren Studio
		MimeMessage mimeMessage2 = javaMailSender.createMimeMessage();
		try {
			
			String subjectForAren = name+" has sent a message";
			
			String contentForAren = MailUtil.getEmailContentForAren(toMailId, name, message, phone);
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage2, true);
			mimeMessageHelper.setFrom(fromMailId, MailUtil.mailName);
			mimeMessageHelper.setTo(fromMailId);
			
			
			mimeMessageHelper.setSubject(subjectForAren);
			
			contentForAren += "<hr><img src='cid:logoImage'/>"
					+"<p style='color:#fff; font-size:14px;'>Aren Studio - Turnkey Interior Solutions</p>";
			
			contentForAren += "</div>";
			
			mimeMessageHelper.setText(contentForAren, true);
			mimeMessageHelper.setSentDate(new Date());
			
			ClassPathResource resource = new ClassPathResource("/static/img/ALogo.png");
			mimeMessageHelper.addInline("logoImage", resource);
			
			javaMailSender.send(mimeMessage2);
		} catch (MessagingException e) {
			returnRes = "0";
		}
		

		return returnRes;
	}
	
	
	
}
