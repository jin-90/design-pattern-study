package me.ukuz.designpattern.factory.abstractfactory;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-17 00:41
 */
public class Iphone implements Mobile {
    @Override
    public String work() {
        return "iphone正在运行";
    }
}
