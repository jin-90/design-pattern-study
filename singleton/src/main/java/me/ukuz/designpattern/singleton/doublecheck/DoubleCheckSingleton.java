package me.ukuz.designpattern.singleton.doublecheck;

/**
 * @author ukuz90
 * @date 2019-05-07
 */
public class DoubleCheckSingleton {

    private DoubleCheckSingleton() {
    }

    private static volatile DoubleCheckSingleton instance;

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
