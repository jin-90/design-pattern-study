package me.ukuz.designpattern.proxy.jdk;

import me.ukuz.designpattern.proxy.IOSimulation;
import me.ukuz.designpattern.proxy.SimpleIOSimulation;

public class TimeUseDynamicProxyTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InterruptedException {
        IOSimulation io = TimeUseDynamicProxy.newInstance(SimpleIOSimulation.class);
        String str = io.read();
        System.out.println("read result: " + str);
    }

}