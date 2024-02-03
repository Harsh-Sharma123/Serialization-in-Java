import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectInputStream;

class Dog implements Serializable{
    int i = 10;
    transient int j = 20;
}

public class TranscientDemo{
    public static void main(String args[]){
        Dog dog = new Dog();

        try{   
            FileOutputStream out = new FileOutputStream("abc.ser");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(dog);
        } catch (Exception e){
            e.printStackTrace();
        }

        try{
            FileInputStream fis = new FileInputStream("abc.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Dog d = (Dog) ois.readObject();
            System.out.println(d.i + " " + d.j);
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}