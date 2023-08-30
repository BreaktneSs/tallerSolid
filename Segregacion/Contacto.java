public class Contacto {

    String name, address, emailAddress, telephone;
    public void setName(String n) { name=n; }
    public String getName() { return name; }
    public void setAddress(String a) { address=a; }
    public String getAddress() { return address; }
    public void setEmailAddress(String ea) { emailAddress=ea; }
    public String getEmailAddress() { return emailAddress; }
    public void setTelephone(String t) { telephone=t; }
    public String getTelephone() { return telephone; }
    
}

/**Consultas:
1. ¿Qué información necesitan las clases EmailSender y SMSSender de la clase Contacto
para realizar su tarea, y qué información recogen? Consideras que incumplen en
principio ISP.
2. Refactoriza las clases anteriores, sustituyendo el parámetro Contacto, por una interfaz.
Esta interfaz tendrá los métodos necesarios para acceder a la información que necesita
en método. Modifica también la clase Contacto.
3. Piensa que después de refactorización, la clase GmailAccount (con alguna modificación)
podrá ser enviada a la clase EmailSender pero no a la clase SMSSender.
public class GmailAccount {
String name, emailAddress;
}
Crea un programa que permita invocar al método sendEmail de la clase EmailSender con
un objeto de la clase GmailAccount. */
/**Solución:
1. Las clases EmailSender y SMSSender necesitan información puntualde la clase Contacto para realizar 
su tarea de enviar correos electrónicos y SMS respectivamente. 
por lo tanto, la información que necesitan es la información de contacto del destinatario, 
que está representada por las propiedades de la clase Contacto:

    EmailSender: Necesita la dirección de correo electrónico del contacto para enviar un 
    correo electrónico.

    SMSSender: Necesita el número de teléfono del contacto para enviar un mensaje SMS.

La información que recogen estas clases es el mensaje que se enviará al contacto.

En este caso, parece que tanto EmailSender como SMSSender incumplen el principio ISP. 
Esto se debe a que estas clases son clases de envío de mensajes y solo necesitan los 
datos relevantes para su acción particular (dirección de correo electrónico para email 
y número de teléfono para SMS), pero en su forma actual, estas clases también tienen
 que implementar métodos sendEmail y sendSMS, incluso si estos métodos no son relevantes 
 para la funcionalidad de envío de mensajes en sí

2. public interface ContactInformation {
    String getName();
    String getAddress();
    String getEmailAddress();
    String getTelephone();
}
public class Contacto implements ContactInformation {
    private String name, address, emailAddress, telephone;

    public void setName(String n) { name = n; }
    public String getName() { return name; }
    public void setAddress(String a) { address = a; }
    public String getAddress() { return address; }
    public void setEmailAddress(String ea) { emailAddress = ea; }
    public String getEmailAddress() { return emailAddress; }
    public void setTelephone(String t) { telephone = t; }
    public String getTelephone() { return telephone; }
}
public interface MessageSender {
    void sendMessage(ContactInformation contact, String message);
}
public class EmailSender implements MessageSender {
    public void sendMessage(ContactInformation contact, String message) {
        // Envía un correo electrónico utilizando contact.getEmailAddress()
    }
}
public class SMSSender implements MessageSender {
    public void sendMessage(ContactInformation contact, String message) {
        // Envía un mensaje SMS utilizando contact.getTelephone()
    }
}
Se definido una interfaz ContactInformation que define los métodos necesarios para acceder a
 la información de contacto. La clase Contacto implementa esta interfaz.
Se creola interfaz MessageSender para definir el método sendMessage, y las clases EmailSender 
y SMSSender implementan esta interfaz para enviar correos electrónicos y mensajes SMS.
3. 


public interface ContactInformation {
    String getName();
    String getAddress();
    String getEmailAddress();
    String getTelephone();
}

public class Contacto implements ContactInformation {
    // ...
}
public class GmailAccount implements ContactInformation {
    private String name, emailAddress;

    // Implementa los métodos de la interfaz ContactInformation
    public String getName() { return name; }
    public String getAddress() { return null; }  // Puedes dejar este como null para Gmail
    public String getEmailAddress() { return emailAddress; }
    public String getTelephone() { return null; }  // Puedes dejar este como null para Gmail
}

public class EmailSender implements MessageSender {
    public void sendMessage(ContactInformation contact, String message) {
        // Envía un correo electrónico utilizando contact.getEmailAddress()
    }
}

public class SMSSender implements MessageSender {
    public void sendMessage(ContactInformation contact, String message) {
        // Envía un mensaje SMS utilizando contact.getTelephone()
    }
}

public class Main {
    public static void main(String[] args) {
        GmailAccount gmailAccount = new GmailAccount();
        gmailAccount.setName("John Doe");
        gmailAccount.setEmailAddress("johndoe@gmail.com");

        EmailSender emailSender = new EmailSender();
        String message = "Hola, esto es un correo de prueba.";
        emailSender.sendMessage(gmailAccount, message);
    }
}
Secrea un objeto GmailAccount, lo configura con un nombre y una dirección 
de correo electrónico, y luego utiliza el EmailSender para enviar un correo electrónico 
utilizando el método sendMessage. La clave aquí es que la clase GmailAccount implementa 
la interfaz ContactInformation, lo que le permite ser utilizado en el contexto del EmailSender.
 */