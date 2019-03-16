package me.ukuz.designpattern.factory.abstractfactory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeviceFactoryTest {

    @Test
    public void createMobile() {
        DeviceFactory deviceFactory1 = new AppleFactory();
        Assert.assertEquals("iphone正在运行", deviceFactory1.createMobile().work());

        DeviceFactory deviceFactory2 = new XiaoMiFactory();
        Assert.assertEquals("Mix正在运行", deviceFactory2.createMobile().work());

    }

    @Test
    public void createLaptop() {
        DeviceFactory deviceFactory1 = new AppleFactory();
        Assert.assertEquals("MacbookPro正在运行", deviceFactory1.createLaptop().work());

        DeviceFactory deviceFactory2 = new XiaoMiFactory();
        Assert.assertEquals("小米Air正在运行", deviceFactory2.createLaptop().work());
    }
}