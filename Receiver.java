import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Receiver {
    public static void main(String[] args) {
        try{
            FileInputStream fis = new FileInputStream("abc.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Dog d = (Dog) ois.readObject();
            System.out.println(d.i);
            System.out.println("Hello");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
