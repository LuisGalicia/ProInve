/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author lugad
 */
public class VerificacionCorreo {

    private String remitente = "lugadaga_skater@hotmail.com";  //Para la dirección nomcuenta@gmail.com
    private String clave = "Inquisidorduy97";
    private String destinatario = "jesus_hdezmtz@hotmail.com";

    public void verificando() throws MessagingException {
        int valorEntero = (int) Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
        System.out.println("El número de verificación es: " + valorEntero);
        Properties props = new Properties();
             props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.live.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");


        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(remitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));

            message.setSubject("Solicitud de mensaje");

            message.setText("Tu código de verificación es: " + valorEntero);

            Transport trans = session.getTransport("smtp");
            trans.connect("smtp.live.com", 587, remitente, clave);
            trans.sendMessage(message, message.getAllRecipients());

            System.out.println("Message Sent!");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
