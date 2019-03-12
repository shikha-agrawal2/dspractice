package designing;

import java.io.*;

public class SingletonSerDemo {

    public static void main(String[] args) {
        SingletonSer obj = SingletonSer.getInstance();
        System.out.println("After NEW Object creation : " + obj);

        obj.i = 5;
        System.out.println("Object modified");
        System.out.println("After Object 1st Modification : " + obj);

        serializeMe();
        System.out.println("Serialized successfully with object state : " + obj);

        obj.i = 10;
        System.out.println("Object modified again");
        System.out.println("After Object 2nd Modification : " + obj);

        SingletonSer st = (SingletonSer) deSerializeMe();
        System.out.println("Deserialized successfully");

        System.out.println("After Deserialization : " + st);
    }

    public static void serializeMe() {
        FileOutputStream fos;
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("d:\\SingletonSerData.txt"));
            oos.writeObject(SingletonSer.getInstance());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deSerializeMe() {
        ObjectInputStream oin = null;
        Object obj = null;

        try {
            oin = new ObjectInputStream(new FileInputStream("d:\\SingletonSerData.txt"));
            obj = oin.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;
    }

}
