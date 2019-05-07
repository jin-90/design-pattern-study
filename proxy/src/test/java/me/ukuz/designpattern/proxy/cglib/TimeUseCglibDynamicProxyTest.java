package me.ukuz.designpattern.proxy.cglib;

import me.ukuz.designpattern.proxy.SimpleStreamSimulation;

public class TimeUseCglibDynamicProxyTest {

    public static void main(String[] args) throws InterruptedException {
        SimpleStreamSimulation io = TimeUseCglibDynamicProxy.newInstance(SimpleStreamSimulation.class);
        String str = io.read();
        System.out.println("read result: " + str);
    }

}