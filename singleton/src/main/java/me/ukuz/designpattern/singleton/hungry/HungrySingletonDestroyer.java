package me.ukuz.designpattern.singleton.hungry;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-17 02:27
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
