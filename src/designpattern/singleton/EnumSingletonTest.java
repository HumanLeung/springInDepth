package designpattern.singleton;

import java.io.*;

/**
 * @author Administrator
 */
public class EnumSingletonTest {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            EnumSingleton instance1 = null;
            EnumSingleton instance2 = EnumSingleton.getInstance();
            instance2.setData(new Object());
             fos = new FileOutputStream("EnumSingleton.obj");
             oos = new ObjectOutputStream(fos);
            oos.writeObject(instance2);
            oos.flush();
            oos.close();

            fis = new FileInputStream("EnumSingleton.obj");
            ois = new ObjectInputStream(fis);
            instance1  = (EnumSingleton) ois.readObject();
            ois.close();

            System.out.println(instance1.getData());
            System.out.println(instance2.getData());
            System.out.println(instance1.getData() == instance2.getData());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                oos.close();
                fis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
