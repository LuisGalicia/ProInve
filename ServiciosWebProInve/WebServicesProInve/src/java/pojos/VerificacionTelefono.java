/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import javax.mail.MessagingException;

/**
 *
 * @author lugad
 */
public class VerificacionTelefono {
    // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACaf689c46c13707e83c841529d40da8f7";
  public static final String AUTH_TOKEN = "2b823468f2b4e51ab9558b66293c0ca7";

  public int verificaNumero(String numero) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    int valorEntero = (int) Math.floor(Math.random()*(9999-1000+1)+1000);
    Message message = Message.creator(new PhoneNumber("+52" + numero),
        new PhoneNumber("+16125646690"), 
        "Gracias por registrarte a ProInvest inversiones. Tu número de verificación es: " + valorEntero).create();
        System.out.println(message.getSid());
        System.out.println("El número es: " + valorEntero);
        return valorEntero;
  }

}
