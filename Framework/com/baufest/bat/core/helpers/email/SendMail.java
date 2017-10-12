package com.baufest.bat.core.helpers.email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendMail {
    public SendMail() throws MessagingException {
        String host = "smtp.gmail.com";
        String Password = "";
        String from = "miguelangelmuro10@gmail.com";
        String toAddress = "miguelangelmuro10@gmail.com";
        String filename = "test-output/report/2017-10-12-03-23-50.html";
        // Get system properties
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, null);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));

        message.setRecipients(Message.RecipientType.TO, toAddress);

        message.setSubject("JavaMail Attachment");

        BodyPart messageBodyPart = new MimeBodyPart();



        String messageT = "<table border='2px'><tr><td>Celda 1</td><td>Celda 2</td><td>Celda 3</td></tr><tr><td>Celda 4</td><td>Celda 5</td><td>Celda 6</td></tr></table>";
        /*messageT += "<b>Wish you a nice day!</b><br>";
        messageT += "<font color=red>Duke</font>"; */

        messageBodyPart.setContent(messageT,"text/html");

        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();

        DataSource source = new FileDataSource(filename);

        messageBodyPart.setDataHandler(new DataHandler(source));

        messageBodyPart.setFileName(filename);

        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        try {
            Transport tr = session.getTransport("smtps");
            tr.connect(host, from, Password);
            tr.sendMessage(message, message.getAllRecipients());
            System.out.println("Mail Sent Successfully");
            tr.close();

        } catch (SendFailedException sfe) {

            System.out.println(sfe);
        }
    }
    public static void main(String args[]){
        try {
            SendMail sm = new SendMail();
        } catch (MessagingException ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}