package com.chainsys.Util;


import java.io.IOException;
import java.util.Properties;


import javax.mail.BodyPart;
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

 public class MailUtil1
{  
public static void send(final String from,final String password,String to,String sub,String Msg) throws IOException
{  
Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");  
        props.put("mail.smtp.ssl.checkserveridentity", true); 
        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() 
        {    
        protected PasswordAuthentication getPasswordAuthentication() 
        {    
        return new PasswordAuthentication(from,password);  
        }      
        });    
        try 
        {    
        MimeMessage message = new MimeMessage(session);    
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
        message.setSubject(sub);    
        Multipart multipart = messageBody(Msg);
            message.setContent(multipart );  
        Transport.send(message);    
        System.out.println("message sent successfully");    
        }
        catch (MessagingException e) 
        {
        throw new RuntimeException(e);
        }    
}

private static Multipart messageBody(String Msg) throws MessagingException{ {
BodyPart messageBodyPart1 = new MimeBodyPart();  
messageBodyPart1.setText("Prime OTP Assitance");  
BodyPart messageBodyPart2 = new MimeBodyPart(); 
messageBodyPart2.setText("\nTo authenticate, please use the following One Time Password (OTP):");

BodyPart messageBodyPart3 = new MimeBodyPart(); 
messageBodyPart3.setText(Msg);
BodyPart messageBodyPart4 = new MimeBodyPart(); 
messageBodyPart4.setText("Do not share this OTP with anyone. \nAmazon takes your account security very seriously. \nAmazon Customer Service will never ask you to disclose or \nverify your Amazon password, OTP, credit card, or banking account number. ");
BodyPart messageBodyPart5 = new MimeBodyPart(); 
messageBodyPart5.setText("");

/*String filename = "SendAttachment.java";  
FileDataSource source = new FileDataSource("./src/test/java/com/chainsys/PayrollApp/SendMailSSL.java");  
messageBodyPart2.setDataHandler(new DataHandler(source));  
messageBodyPart2.setFileName(filename); */

Multipart multipart = new MimeMultipart();  
multipart.addBodyPart(messageBodyPart1);  
multipart.addBodyPart(messageBodyPart2);
multipart.addBodyPart(messageBodyPart3);
multipart.addBodyPart(messageBodyPart4);
multipart.addBodyPart(messageBodyPart5);
return multipart; 


 }
}
}

