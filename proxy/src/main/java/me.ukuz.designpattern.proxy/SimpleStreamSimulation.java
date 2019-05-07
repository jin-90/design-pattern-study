package me.ukuz.designpattern.proxy;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author ukuz90
 * @date 2019-05-04
 */
public class SimpleStreamSimulation implements StreamSimulation {
    @Override
    public String read() throws InterruptedException {
        long timeUse = new Random().nextInt(2000) + 50;
        TimeUnit.MILLISECONDS.sleep(timeUse);

        return "Hello World";
    }

    @Override
    public boolean write(String msg) {
        return new Random().nextBoolean();
    }
}
