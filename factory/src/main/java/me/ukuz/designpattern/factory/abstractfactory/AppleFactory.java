package me.ukuz.designpattern.factory.abstractfactory;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-17 00:40
 */
public class AppleFactory implements DeviceFactory {
    @Override
    public Mobile createMobile() {
        return new Iphone();
    }

    @Override
    public Laptop createLaptop() {
        return new MacbookPro();
    }
}
