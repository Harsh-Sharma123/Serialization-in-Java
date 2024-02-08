import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Animal implements Externalizable{

    int i;
    int j;
    String s;

    public Animal(){
        System.out.println("Animal Class Constructor!!");
    }

    Animal(int i, int j, String s){
        this.i = i;
        this.j = j;
        this.s = s;
    }

    public void writeExternal(ObjectOutput out) throws IOException{
        out.writeObject(s);
        out.writeInt(i);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
        s = (String) in.readObject();
        i = in.readInt();
    }
}

public class Externalization {
    public static void main(String[] args) {
        Animal a = new Animal(10, 20, "Dog");

        try{
            FileOutputStream fos = new FileOutputStream("abc.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a);
        } catch (Exception e){
            e.printStackTrace();
        }

        try{
            FileInputStream fis = new FileInputStream("abc.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Animal a2 = (Animal) ois.readObject();
            System.out.println(a2.i + " " + a2.j + " " + a2.s);;
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
