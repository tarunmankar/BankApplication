package P1;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Credential extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");	
		session=request.getSession(true);
		session.setAttribute("email", email);
		
		final String fromEmail="demo.mail@gmail.com"; //sender's mail id.
		final String pwd="demo1234";		//sender's mail pwd.
		String toEmail=email;  //reciever's mail id.
		
		String subject="DO NOT REPLY: Mail from Java Program"; // mail subject line
		String msg="Click here to change password http://localhost:8070/BankApp/ChangeNPwd.html"; //mail body
		
		//Creating Session Object
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
				return new PasswordAuthentication(fromEmail, pwd);
			}
		});

		try {
		//Composing the Mail
		MimeMessage mesg = new MimeMessage(session);
		mesg.setFrom(new InternetAddress(fromEmail));
		mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
		mesg.setSubject(subject);  
		mesg.setText(msg);  
		
		//Sending the Mail
		Transport.send(mesg);
		System.out.println("Mail Sent!!");
	      }
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
