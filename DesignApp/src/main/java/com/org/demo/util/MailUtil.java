package com.org.demo.util;

public class MailUtil {
	
	public static String toEmail = "sales@arenstudio.in";
	public static String mailName = "Aren Studio";
	public static String emailSubject = "Thank you for Contacting Aren Studio !";
	
	public static boolean isJarMode = true;
	
	
	public static String getEmailContent(String message, String name) {
		String content = "<div style='background-color:#323336; padding:15px;'>"
				+ "<p style='color:#fff; font-size:14px;'>Hi,</p>"
				+ "<br>"
				+ "<p style='color:#fff; font-size:14px;'>Thank you for showing interest. "
				+ "Our Designer will be in touch with you shortly.</p>"
				+ "<p style='color:#fff; font-size:14px;'>In the meantime, you can check out the services provided by us in our website</p>"
				+"<br>";

		return content;
	}
	
	public static String getEmailContentForAren(String email, String name, String message, String phone) {
		String content = "<div style='background-color:#323336; padding:15px;'>"
				+ "<p style='color:#fff; font-size:14px;'>"+name+" tried contacting you.</p>"
				+ "<br>"
				+ "<p style='color:#fff; font-size:14px;'>Sender Name : "+name+"</p>"
				+ "<p style='color:#fff; font-size:14px;'>Sender Email : "+email+"</p>"
				+ "<p style='color:#fff; font-size:14px;'>Sender Phone number : "+phone+"</p>"
				+ "<p style='color:#fff; font-size:14px;'>Message : "+message+"</p>"
				+"<br>";

		return content;
		
	}

}
