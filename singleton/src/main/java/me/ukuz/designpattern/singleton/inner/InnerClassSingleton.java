package me.ukuz.designpattern.singleton.inner;

import java.io.Serializable;

/**
 * @author ukuz90
 * @date 2019-05-07
 */
public class InnerClassSingleton implements Serializable {

    private InnerClassSingleton() {}

    public static InnerClassSingleton getInstance() {
        return InnerClass.instance;
    }

    private static class InnerClass {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    /**
     * 防止利用反序列化的方式破坏单例
     * @return
     */
    public Object readResolve() {
        return getInstance();
    }
}
