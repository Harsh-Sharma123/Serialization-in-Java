import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog implements Serializable{
    Cat c = new Cat();
}

class Cat implements Serializable{
    Rat r = new Rat();
}

class Rat implements Serializable{
    int i = 20;
}

public class ObjectGraph {
    public static void main(String args[]){
        Dog d = new Dog();

        try{
            FileOutputStream fos = new FileOutputStream("abc.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(d);
        } catch (Exception e){
            e.printStackTrace();
        }

        try{
            FileInputStream fis = new FileInputStream("abc.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Dog d2 = (Dog) ois.readObject();
            System.out.println("After Deserialization : ");
            System.out.println(d2.c.r.i);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
