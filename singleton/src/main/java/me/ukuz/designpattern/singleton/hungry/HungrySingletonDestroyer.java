package me.ukuz.designpattern.singleton.hungry;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ukuz90
 * @date 2019-03-17
 */
public class HungrySingletonDestroyer {

    public static HungrySingleton createByReflect() {
        try {
            Class<HungrySingleton> clazz = HungrySingleton.class;
            Constructor<HungrySingleton> contructor = clazz.getDeclaredConstructor();
            contructor.setAccessible(true);
            return contructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HungrySingleton createBySerializable() {

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            HungrySingleton hungrySingletonA = HungrySingleton.getInstance();
            oos.writeObject(hungrySingletonA);

            try (ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray()); ObjectInputStream ois = new ObjectInputStream(bis)) {
                HungrySingleton hungrySingletonB = (HungrySingleton) ois.readObject();
                System.out.println(hungrySingletonA);
                System.out.println(hungrySingletonB);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
