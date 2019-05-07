package me.ukuz.designpattern.singleton.hungry;

import java.io.Serializable;

/**
 * 饿汉式单例
 * @author ukuz90
 * @date 2019-03-17
 */
public class HungrySingleton implements Serializable {

    private HungrySingleton() {
    }

    private static final HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }

    public Object readResolve() {
        return instance;
    }

}
