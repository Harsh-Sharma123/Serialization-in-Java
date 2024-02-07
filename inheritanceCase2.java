import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Animal{
    int i = 10;

    public Animal(){
        System.out.println("Animal Class Constructor!");
    }
}

class Dog extends Animal implements Serializable{
    int j = 20;

    Dog(){
        System.out.println("Dog class Contructor !");
    }
}

public class inheritanceCase2 {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.i = 888;
        d1.j = 999;
        
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
