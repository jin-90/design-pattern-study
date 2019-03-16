package me.ukuz.designpattern.factory.simplefactory;

import me.ukuz.designpattern.factory.Fruit;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-17 00:04
 */
public class FruitFactory {

    public <T extends Fruit> T create(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
