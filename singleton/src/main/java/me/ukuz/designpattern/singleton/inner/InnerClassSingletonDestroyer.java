package me.ukuz.designpattern.singleton.inner;

import java.io.*;

/**
 * @author ukuz90
 * @date 2019-05-07
 */
public class InnerClassSingletonDestroyer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        InnerClassSingleton instance2;

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            oos.writeObject(instance);

            try (ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                 ObjectInputStream ois = new ObjectInputStream(bis)) {
                instance2 = (InnerClassSingleton) ois.readObject();
            }
        }

        System.out.println(instance);
        System.out.println(instance2);
    }

}
