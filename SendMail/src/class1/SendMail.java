package class1;



import java.util.Properties;

import javax.mail.Message;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.mail.PasswordAuthentication;

public class SendMail {

	public static void main(String[] args) {
		String password = "8109656273";
	
		try{
	        Properties property = new Properties();
	        property.setProperty("mail.smtp.host", "smtp.gmail.com");
	        property.setProperty("mail.smtp.starttls.enable", "true");
	        //property.setProperty("mail.smpt.port", "25");
	        property.setProperty("mail.smtp.user", "shubham.sonare.71@gmail.com");
	        property.setProperty("mail.smtp.auth", "true");

	        System.out.println("Mail Check 1");
	        
	        
	        Session session = Session.getDefaultInstance(property, 
	        	    new javax.mail.Authenticator(){
	        	        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	        	            return new PasswordAuthentication(
	        	                "shubham.sonare.71@gmail.com", password);// Specify the Username and the PassWord
	        	        }
	        	});

	        
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("shubham.sonare.71@gmail.com"));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress("parwatraosonare@gmail.com"));

	        System.out.println("Mail Check 2");

	        message.setSubject("yeah..!! ");
	        message.setText("Trying to send an email using API");

	        System.out.println("Mail Check 3");

	        Transport transport = session.getTransport("smtps");
	        transport.connect("smtp.gmail.com",465,"shubham.sonare.71@gmail.com",password);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();

	        System.out.println("Mail Sent");
	    }catch(Exception ex){
	        System.out.println("Mail fail");
	        System.out.println(ex);
	    }
	}
}


