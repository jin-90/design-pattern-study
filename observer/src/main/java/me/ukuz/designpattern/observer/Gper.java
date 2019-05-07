package me.ukuz.designpattern.observer;

/**
 * @author ukuz90
 * @date 2019-03-20
 */
public interface Gper {

    String getName();

    void interest(Label...label);

    void send(Question question);

    boolean hasInterest(Label label);
}
