package me.ukuz.designpattern.singleton.hungry;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HungrySingletonDestroyerTest {

    @Test
    public void createByReflect() {
        HungrySingleton hungrySingleton1 = HungrySingletonDestroyer.createByReflect();
        Assert.assertNotNull(hungrySingleton1);
        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
        Assert.assertTrue(hungrySingleton1 != hungrySingleton2);
    }

    @Test
    public void createBySerializable() {
        HungrySingleton hungrySingleton1 = HungrySingletonDestroyer.createBySerializable();
        Assert.assertNotNull(hungrySingleton1);
        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
        Assert.assertTrue(hungrySingleton1 != hungrySingleton2);
    }
}