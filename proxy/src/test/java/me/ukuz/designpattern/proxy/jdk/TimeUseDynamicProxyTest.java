package me.ukuz.designpattern.proxy.jdk;

import me.ukuz.designpattern.proxy.StreamSimulation;
import me.ukuz.designpattern.proxy.SimpleStreamSimulation;

public class TimeUseDynamicProxyTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InterruptedException {
        StreamSimulation io = TimeUseDynamicProxy.newInstance(SimpleStreamSimulation.class);
        String str = io.read();
        System.out.println("read result: " + str);
    }

}