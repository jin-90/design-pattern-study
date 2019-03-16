package me.ukuz.designpattern.factory.factorymethod;

import me.ukuz.designpattern.factory.Fruit;
import me.ukuz.designpattern.factory.Watermelon;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-17 00:25
 */
public class WatermelonFactory implements FruitFactory {
    @Override
    public Fruit create() {
        return new Watermelon();
    }
}
