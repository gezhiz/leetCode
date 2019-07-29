package com.gerson.design.observer;

/**
 * Created by gezz on 2019/3/14.
 */
public interface Observable {

    void register(Observer observer);
    void remove(Observer observer);
    void notifyObserver();//通知观察者

    String getData();//需要发布的数据
}
