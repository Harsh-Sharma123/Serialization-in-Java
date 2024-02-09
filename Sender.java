import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog implements Serializable{

    private static final long serialVerionUID = 1L;
    int i = 10;
}

public class Sender {
    public static void main(String[] args) {
        Dog d = new Dog();

        try{
            FileOutputStream fos = new FileOutputStream("abc.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
