/**
 * 
 */
package bookmyshow.sms.mail.api.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookmyshow.sms.mail.api.config.PaymentConfirmationMailToBookMyShow;
import bookmyshow.sms.mail.api.model.UserPaymentConfirmation;

/**
 * @author M1048474
 *
 */
@RestController
@RequestMapping("bookmyshow/paymentconfirmation/mail")
public class MailController {

	@Autowired
	PaymentConfirmationMailToBookMyShow paymentConfirmationMailToBookMyShow;

	@PostMapping
	public void sendmail(@RequestBody UserPaymentConfirmation userPaymentConfirmation, BindingResult bindingResult)
			throws MessagingException, Exception {
		if (bindingResult.hasErrors()) {
			throw new ValidationException("Feedback is not valid");
		}

		// Create a mail sender
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(paymentConfirmationMailToBookMyShow.getHost());
		// mailSender.setPort(paymentConfirmationMailToBookMyShow.getPort());
		mailSender.setUsername(paymentConfirmationMailToBookMyShow.getUsername());
		mailSender.setPassword(paymentConfirmationMailToBookMyShow.getPassword());

		// Create an email instance
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(userPaymentConfirmation.getEmail());
		mailMessage.setTo("amrishk325@gmail.com");
		mailMessage.setSubject("New payment confirmation from : " + userPaymentConfirmation.getUserName());
		mailMessage.setText(userPaymentConfirmation.getStatus());

		// Send mail
		mailSender.send(mailMessage);

	}

	
	@GetMapping("/send")
	public String transport() throws MessagingException {
		
		    String to = "javac832@gmail.com";
		    String subject = "subject";
		    String msg ="email text....";
		    final String from ="shiv.amrish2011@gmail.com";
		    final String password ="@@Amrish1234";


		    Properties props = new Properties();  
		    props.setProperty("mail.transport.protocol", "smtp");     
		    props.setProperty("mail.host", "smtp.gmail.com");  
		    props.put("mail.smtp.auth", "true");  
		    props.put("mail.smtp.port", "465");  
		    props.put("mail.debug", "true");  
		    props.put("mail.smtp.socketFactory.port", "465");  
		    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
		    props.put("mail.smtp.socketFactory.fallback", "false");  
		    Session session = Session.getInstance(props,   new javax.mail.Authenticator() {
		       protected PasswordAuthentication getPasswordAuthentication() {  
		       return new PasswordAuthentication(from,password);  
		   }  
		   } );
		    

		   //session.setDebug(true);  
		   Transport transport = session.getTransport();  
		   InternetAddress addressFrom = new InternetAddress(from);  

		   MimeMessage message = new MimeMessage(session);  
		   message.setSender(addressFrom);  
		   message.setSubject(subject);  
		   message.setContent(msg, "text/plain");  
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

		   transport.connect();  
		   Transport.send(message);  
		   transport.close();
		   
		   return "Successfully";
		   }
	
	@GetMapping("/pdf")
	public String sendEmailWithPdf() {
		
		//authentication info
				final String username = "Amrish kumar";
				final String password = "@@Amrish1234";
				String fromEmail = "shiv.amrish2011@gmail.com";
				String toEmail = "javac832@gmail.com";
				   Properties props = new Properties();  
				    props.setProperty("mail.transport.protocol", "smtp");     
				    props.setProperty("mail.host", "smtp.gmail.com");  
				    props.put("mail.smtp.auth", "true");  
				    props.put("mail.smtp.port", "465");  
				    props.put("mail.debug", "true");  
				    props.put("mail.smtp.socketFactory.port", "465");  
				    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
				    props.put("mail.smtp.socketFactory.fallback", "false");  
				
				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(fromEmail,password);
					}
				});
				//Start our mail message
				MimeMessage msg = new MimeMessage(session);
				try {
					msg.setFrom(new InternetAddress(fromEmail));
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
					msg.setSubject("Subject Line");
					
					Multipart emailContent = new MimeMultipart();
					
					//Text body part
					MimeBodyPart textBodyPart = new MimeBodyPart();
					textBodyPart.setText("My multipart text");
					
					//Attachment body part.
					MimeBodyPart pdfAttachment = new MimeBodyPart();
					pdfAttachment.attachFile("C:\\Users\\M1048474\\Desktop\\Movie_Booking_Architecture_Angular.pdf");
					
					//Attach body parts
					emailContent.addBodyPart(textBodyPart);
					emailContent.addBodyPart(pdfAttachment);
					
					//Attach multipart to message
					msg.setContent(emailContent);
					
					Transport.send(msg);
					System.out.println("Sent message");
				} catch (MessagingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return "Email sent Successfully";

		
	}
	
}

