package me.ukuz.designpattern.factory.abstractfactory;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-17 00:46
 */
public class XiaoMiFactory implements DeviceFactory {
    @Override
    public Mobile createMobile() {
        return new Mix();
    }

    @Override
    public Laptop createLaptop() {
        return new XiaoMiAir();
    }
}
