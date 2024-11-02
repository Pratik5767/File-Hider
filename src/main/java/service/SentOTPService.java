package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.PasswordAuthentication;

public class SentOTPService {
    public static void sentOTP(String email, String genOTP) {
        // Recipient's email ID need to be mentioned
        String to = email;

        // Sender's email ID need to be mentioned
        String from = "Enter the email throught otp is to be sent";

        // Assuming your sending email from gmail smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the session object and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "aesbuqdgrdsaxljo");
            }
        });

        // use to debug SMTP issues
        session.setDebug(true);

        try {
            // create a default MinMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set from: header field of the header
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("File Encrp OTP");
            // Now set the actual message
            message.setText("Your One time password for file Encrp app is: " + genOTP);
            System.out.println("sending...");
            //send Message
            Transport.send(message);
            System.out.println("Sent Message Successfully....");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
