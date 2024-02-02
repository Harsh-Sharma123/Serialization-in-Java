import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog implements Serializable{
    int i = 10;
    int j = 20;
}

public class DemoProgram{
    public static void main(String args[]) {
        Dog dog = new Dog();

        // Serialization
        try{
            FileOutputStream out = new FileOutputStream("abc.ser");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(dog);

            System.out.println("Serialization Done !");
        } catch (Exception e){
            e.printStackTrace();
        }

        // Deserialization
        try{
            FileInputStream fis = new FileInputStream("abc.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Dog d2 = (Dog) ois.readObject();
            System.out.println("After Deserialization !");
            System.out.println(d2.i + " " + d2.j);
        } catch (Exception e){
            e.printStackTrace();
        }

        
    }
}