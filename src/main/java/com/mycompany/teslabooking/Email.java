package com.mycompany.teslabooking;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    private static String USERNAME = "*****"; // GMail username - just the bit before @gmail.com
    private static String PASSWORD = "*****"; //GMail password
    private static String RECIPIENT = "timkanders@gmail.com";

    /**
     * I know recipient is meant to be the email address of the passenger but i hardcoded this to send the email to a second account i have
     * as god only knows who id be sending it to otherwise.I printed
     * the 'recipients email' in the body just to show i could get the email and use it.
     * Cameron Helped me make this as i couldnt get original code to work
     */
    public static void EmailPrep(String Useremail)
    {
        String from = USERNAME;
        String pass = PASSWORD;
        String[] to = {RECIPIENT};
        String subject = "Your Car Booking";
        String body = "Thanks for choosing GD2 cars "+Useremail;

        sendFromGmail(from, pass, to, subject, body);
    }

    private static void sendFromGmail(String from, String password, String[] to, String subject, String body)
    {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";

        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try
        {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            //TODO - Deal with possible array of addresses
            for (int i = 0; i < toAddress.length; i++)
            {
                toAddress[i] = new InternetAddress(to[i]);
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException e)
        {
            e.printStackTrace();
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }
    }


}
