package me.ukuz.designpattern.singleton.hungry;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

//        try (ObjectOutputStream oos = new ObjectOutputStream()) {
//        }

        return null;

    }

}
