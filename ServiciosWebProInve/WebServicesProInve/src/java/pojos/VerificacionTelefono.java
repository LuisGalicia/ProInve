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
  public static final String ACCOUNT_SID = "AC6470e628cdfe127b72a9ebfe5c544647";
  public static final String AUTH_TOKEN = "cf1ff6bf4b020962e8288477e7832c69";

 /* public static void main(String[] args) throws MessagingException {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    VerificacionCorreo v = new VerificacionCorreo();
    v.verificando();
    int valorEntero = (int) Math.floor(Math.random()*(9999-1000+1)+1000);
    Message message = Message.creator(new PhoneNumber("+522281818876"),
        new PhoneNumber("+18563241001"), 
        "Que tranza perro, dame el número de verificación" + valorEntero).create();
      System.out.println("El número es: " + valorEntero);
    
  }*/

}
