package me.ukuz.designpattern.factory.factorymethod;

import me.ukuz.designpattern.factory.Fruit;
import me.ukuz.designpattern.factory.Lemon;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-17 00:26
 */
public class LemonFactory implements FruitFactory {
    @Override
    public Fruit create() {
        return new Lemon();
    }
}
