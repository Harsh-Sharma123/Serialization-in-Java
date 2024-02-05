import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Account implements Serializable{
    String user = "Admin";
    transient String password = "Admin@123";
    
    private void writeObject(ObjectOutputStream oos) throws Exception{
        oos.defaultWriteObject();
        String epwd = "123" + password;
        oos.writeObject(epwd);
    }

    private void readObject(ObjectInputStream ois) throws Exception{
        ois.defaultReadObject();
        String epwd = (String) ois.readObject();
        password =  epwd.substring(3);
    }
}

public class CustomisedSerialization {
    public static void main(String args[]){
        Account a1 = new Account();

        try{
            FileOutputStream fos = new FileOutputStream("abc.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a1);
        } catch (Exception e){
            e.printStackTrace();
        }

        try{
            FileInputStream fis = new FileInputStream("abc.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Account a2 = (Account) ois.readObject();
            System.out.println(a2.user + " " + a2.password);
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
