package com.mycompany.emailclientmo;

import java.io.File;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailClientmo {

    public static void main(String[] args) {
        System.out.println("Prepare to send message...");

        String htmlMessage = "<h1>Hello</h1><p>This is an HTML message for security check.</p>";
        String subject = "Codeclause: Confirmation";
        String to = "recipient@example.com"; // Enter the recipient's email
        String from = "sender@example.com"; // Enter the sender's email

        sendEmail(htmlMessage, subject, to, from);
        sendAttach(htmlMessage, subject, to, from);
    }

    // This is responsible for sending an email with an attachment
    private static void sendAttach(String message, String subject, String to, String from) {
        String host = "localhost"; // Change to localhost
        String port = "1025"; // Port your local SMTP server is listening on

        // Get the system properties
        Properties properties = System.getProperties();
        System.out.println("Properties: " + properties);

        // Setting important information to properties object
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.ssl.enable", "false"); // Disable SSL for local server
        properties.put("mail.smtp.auth", "false"); // Disable auth for local server

        // To get session object
        Session session = Session.getInstance(properties);

        session.setDebug(true);

        try {
            // Step 2: Compose the message
            MimeMessage m = new MimeMessage(session);

            // From email
            m.setFrom(new InternetAddress(from));

            // Adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Adding subject to message
            m.setSubject(subject);

            // Attachment
            // File path
            String path = "C:\\Users\\hp\\OneDrive\\Pictures\\krishnaji.jpg";

            MimeMultipart mimeMultipart = new MimeMultipart();

            // Text
            MimeBodyPart textMime = new MimeBodyPart();
            textMime.setContent(message, "text/html");

            // File
            MimeBodyPart fileMime = new MimeBodyPart();
            File file = new File(path);
            fileMime.attachFile(file);

            mimeMultipart.addBodyPart(textMime);
            mimeMultipart.addBodyPart(fileMime);

            // Set content
            m.setContent(mimeMultipart);

            // Step 3: Sending message using Transport class
            Transport.send(m);

            System.out.println("Sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This is responsible for sending an email
    private static void sendEmail(String message, String subject, String to, String from) {
        String host = "localhost"; // Change to localhost
        String port = "1025"; // Port your local SMTP server is listening on

        // Get the system properties
        Properties properties = System.getProperties();
        System.out.println("Properties: " + properties);

        // Setting important information to properties object
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.ssl.enable", "false"); // Disable SSL for local server
        properties.put("mail.smtp.auth", "false"); // Disable auth for local server

        // To get session object
        Session session = Session.getInstance(properties);

        session.setDebug(true);

        try {
            // Step 2: Compose the message
            MimeMessage m = new MimeMessage(session);

            // From email
            m.setFrom(new InternetAddress(from));

            // Adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Adding subject to message
            m.setSubject(subject);

            // Setting the HTML content
            m.setContent(message, "text/html");

            // Step 3: Sending message using Transport class
            Transport.send(m);

            System.out.println("Sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
