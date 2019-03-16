package me.ukuz.designpattern.factory.simplefactory;

import me.ukuz.designpattern.factory.Fruit;
import me.ukuz.designpattern.factory.Lemon;
import me.ukuz.designpattern.factory.Watermelon;
import org.junit.Assert;
import org.junit.Test;

public class FruitFactoryTest {

    @Test
    public void create() {
        FruitFactory fruitFactory = new FruitFactory();
        Fruit fruit1 = fruitFactory.create(Watermelon.class);
        Assert.assertEquals("西瓜很甜", fruit1.taste());
        Fruit fruit2 = fruitFactory.create(Lemon.class);
        Assert.assertEquals("柠檬很酸", fruit2.taste());
    }
}