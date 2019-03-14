package com.gerson.designPattern.observer;

/**
 * Created by gezz on 2019/3/14.
 */
public interface Observable {

    void register(Observer observer);
    void remove(Observer observer);
    void event();
}
