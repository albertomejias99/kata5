package kata5.model;

public class Mail {


    private final String mail;
    
    public Mail (String mail){
        this.mail = mail;
    }
    
    public static boolean isMail(String line) {
        return line.matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
    }

    public String getDomain() {
        return this.mail.substring(this.mail.indexOf("@")+1);
    }
}
