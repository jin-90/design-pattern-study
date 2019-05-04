package me.ukuz.designpattern.proxy;

public interface IOSimulation {

    String read() throws InterruptedException;

    boolean write(String msg);
}
