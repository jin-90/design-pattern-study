package me.ukuz.designpattern.proxy;

/**
 * @author ukuz90
 * @date 2019-05-04
 */
public interface StreamSimulation {

    String read() throws InterruptedException;

    boolean write(String msg);
}
