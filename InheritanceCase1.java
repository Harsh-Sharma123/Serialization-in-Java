import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Animal implements Serializable{
    int i = 10;
}

class Dog extends Animal{
    int j = 20;
}

public class InheritanceCase1 {
    public static void main(String args[]){
        Dog d1 = new Dog();

        try{
            FileOutputStream fos = new FileOutputStream("abc.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d1);
        } catch (Exception e){
            e.printStackTrace();
        }

        try{
            FileInputStream fis = new FileInputStream("abc.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Dog d2 = (Dog) ois.readObject();
            System.out.println(d2.i + " " + d2.j);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
