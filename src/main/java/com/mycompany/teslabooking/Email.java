package com.mycompany.teslabooking;

//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;

public class Email {
//    private static String USERNAME = "john"; // GMail username - just the bit before @gmail.com
//    private static String PASSWORD = "Pa55w0rd"; //GMail password
//    private static String RECIPIENT = "john.loane@dkit.ie";
//
//    public static void main(String[] args) {
//        String from = USERNAME;
//        String pass = PASSWORD;
//        String[] to = {RECIPIENT}; //list of potentially many people
//        String subject = "Your Car Booking";
//        String body = "Thanks for choosing GD2 Cars";
//
//        sendFromGmail(from, pass, to, subject, body);
//    }
//
//    private static void sendFromGmail(String from, String pass, String[] to, String subject, String body){
//        Properties props = System.getProperties();
//        String host = "smtp.gmail.com";
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.user", from);
//        props.put("mail.smtp.password", pass);
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//
//        Session session = Session.getDefaultInstance(props);
//        MimeMessage message = new MimeMessage(session);
//
//        try{
//            message.setFrom(new InternetAddress(from));
//            InternetAddress[] toAddress = new InternetAddress[to.length];
//
//            //Deal with possible array of addresses
//            for(int i=0; i < to.length; ++i){
//                toAddress[i] = new InternetAddress(to[i]);
//            }
//            for(int i=0; i < toAddress.length; i++){
//                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
//            }
//
//            message.setSubject(subject);
//            message.setText(body);
//            Transport transport = session.getTransport("smtp");
//            transport.connect(host, from, pass);
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
//        }catch(AddressException ae){
//            ae.printStackTrace();
//        }catch(MessagingException me){
//            me.printStackTrace();
//        }
//    }

}
