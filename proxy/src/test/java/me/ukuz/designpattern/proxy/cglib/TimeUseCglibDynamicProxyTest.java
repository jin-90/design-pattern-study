package me.ukuz.designpattern.proxy.cglib;

import me.ukuz.designpattern.proxy.SimpleIOSimulation;

public class TimeUseCglibDynamicProxyTest {

    public static void main(String[] args) throws InterruptedException {
        SimpleIOSimulation io = TimeUseCglibDynamicProxy.newInstance(SimpleIOSimulation.class);
        String str = io.read();
        System.out.println("read result: " + str);
    }

}