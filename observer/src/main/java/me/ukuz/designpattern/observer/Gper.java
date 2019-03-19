package me.ukuz.designpattern.observer;

public interface Gper {

    String getName();

    void interest(Label...label);

    void send(Question question);

    boolean hasInterest(Label label);
}
