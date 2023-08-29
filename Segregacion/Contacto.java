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