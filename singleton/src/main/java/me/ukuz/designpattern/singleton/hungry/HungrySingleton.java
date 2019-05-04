package me.ukuz.designpattern.singleton.hungry;

import java.io.Serializable;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-17 02:08
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
