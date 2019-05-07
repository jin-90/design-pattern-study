package me.ukuz.designpattern.singleton.enums;

/**
 * 枚举单例可以避免通过反序列化破坏单例
 * @author ukuz90
 * @date 2019-03-17
 */
public enum EnumSingleton {
    /**
     * 枚举单例
     */
    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
