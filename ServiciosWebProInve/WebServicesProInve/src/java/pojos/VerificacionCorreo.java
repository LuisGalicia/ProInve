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

    private String remitente = "wacha_out@outlook.es";  //Para la dirección nomcuenta@gmail.com
    private String clave = "Inquisidorduy97";
    private String destinatario = "david_galicia_garcia@outlook.es";

    public void verificando() throws MessagingException {
        int valorEntero = (int) Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
        System.out.println("El número de verificación es: " + valorEntero);
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.setProperty("mail.smtp.user", remitente);
        props.setProperty("mail.smtp.clave", clave);    //La clave de la cuenta
        props.setProperty("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.setProperty("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.setProperty("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props,  new Authenticator() {
 
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "wacha_out@outlook.es", "Inquisidorduy97");
                    }
                });
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
            message.setSubject("Verificación de correo");
            message.setText("Tu número de verificación de correo es: " + valorEntero);
            Transport transport = session.getTransport("smtp");
            transport.connect("wacha_out@outlook.es", "Inquisidorduy97");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }

    }
}
