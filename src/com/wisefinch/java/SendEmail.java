package com.wisefinch.java;


import java.util.List;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Base class for all the pages.
 *
 */
public class SendEmail extends DriverScript
{
	
	static ReusableComponents reusableComponents = new ReusableComponents();

	/*
	 * public static void main(String [] args) { // email ID of Recipient. String
	 * recipient = "subramanyaiyer14@gmail.com";
	 * 
	 * // email ID of Sender. String sender = "wisefinchuser@gmail.com";
	 * 
	 * // using host as localhost String host = "192.168.1.9";
	 * 
	 * // Getting system properties Properties properties = System.getProperties();
	 * 
	 * // Setting up mail server properties.setProperty("mail.smtp.host", host);
	 * 
	 * // creating session object to get properties Session session =
	 * Session.getDefaultInstance(properties);
	 * 
	 * String workingDir = System.getProperty("user.dir");
	 * System.out.println(workingDir);
	 * 
	 * try { // MimeMessage object. MimeMessage message = new MimeMessage(session);
	 * 
	 * // Set From Field: adding senders email to from field. message.setFrom(new
	 * InternetAddress(sender));
	 * 
	 * // Set To Field: adding recipient's email to from field.
	 * message.addRecipient(Message.RecipientType.TO, new
	 * InternetAddress(recipient));
	 * 
	 * // Set Subject: subject of the email message.setSubject("This is subject");
	 * 
	 * // set body of the email. message.setText("This is a test mail");
	 * 
	 * // creating first MimeBodyPart object BodyPart messageBodyPart1 = new
	 * MimeBodyPart(); messageBodyPart1.setText("This is body of the mail");
	 * 
	 * // creating second MimeBodyPart object BodyPart messageBodyPart2 = new
	 * MimeBodyPart(); String filename = workingDir+"gridsetup.txt"; DataSource
	 * source = new FileDataSource(filename); messageBodyPart2.setDataHandler(new
	 * DataHandler(source)); messageBodyPart2.setFileName(filename);
	 * 
	 * // creating MultiPart object Multipart multipartObject = new MimeMultipart();
	 * multipartObject.addBodyPart(messageBodyPart1);
	 * multipartObject.addBodyPart(messageBodyPart2);
	 * 
	 * 
	 * 
	 * // set body of the email. message.setContent(multipartObject);
	 * 
	 * // Send email. Transport.send(message);
	 * System.out.println("Mail successfully sent"); } catch (MessagingException
	 * mex) { mex.printStackTrace(); } }
	 * 
	 */
	
	
	public static String url = null;// to be picked from the input excel sheet
	public static void main(String[] args) throws UnsupportedEncodingException,IOException {
		
		String workingDir = System.getProperty("user.dir");
		System.out.println(workingDir);
		// email list from the excel
		//String url = reusableComponents.getPropValues("emaillist");
		
	    final String username = "saviwayanad@gmail.com";
	    final String password = "Ironm@n1";

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", true);
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	    try {
	    	suitename = "Financial Report";
	    	String content = "Greetings !! \n";
	    	//content += "Wishing you a nice day! \n";
	    	content += "Please find the attached results for the test, "+ suitename +" \n";
	    	content += "This is an auto generated email, Please don't reply\n";
	    	content += "\n\n";
	    	content += "\n";
	    	content += "Thanks,\n";
	    	content += "WiseFinch Automation Team\n";
	    	content += "PS : You are using the scripts developed by WiseFinch!! \n";
	    	
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("saviwayanad@gmail.com", "WiseFinch user"));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse(url));
	        //suitename = "Financial Report";
	        message.setSubject("Automation Script Run for "+suitename);
	       // message.setText("This mail is auto generated from the code");
	        //message.setContent(content, "text/html");

	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	        BodyPart messageBodyPart1 = new MimeBodyPart();
	        
	        
	       // messageBodyPart1.setText("This mail is auto generated from the code");
	        messageBodyPart1.setText(content);

	        Multipart multipart = new MimeMultipart();
	        
	        messageBodyPart = new MimeBodyPart();
	        String file = workingDir+"/Reports/"+filename;
	        String fileName = filename;
	        //String fileName = "29-08-2021-13-03PnLReport.html";
	        DataSource source = new FileDataSource(file);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileName);
	        
	        multipart.addBodyPart(messageBodyPart);
	        multipart.addBodyPart(messageBodyPart1);

	        message.setContent(multipart);

	        System.out.println("Sending");

	        try {
				Transport.send(message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("unable to send email due to smtp host issue");
			}

	        System.out.println("Done");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	  }
	
	

}
