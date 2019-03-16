package me.ukuz.designpattern.factory.factorymethod;

import me.ukuz.designpattern.factory.Fruit;
import org.junit.Assert;
import org.junit.Test;

public class FruitFactoryTest {

    @Test
    public void create() {
        FruitFactory fruitFactory1 = new WatermelonFactory();
        Fruit fruit1 = fruitFactory1.create();
        Assert.assertEquals("西瓜很甜", fruit1.taste());
        FruitFactory fruitFactory2 = new LemonFactory();
        Fruit fruit2 = fruitFactory2.create();
        Assert.assertEquals("柠檬很酸", fruit2.taste());
    }
}