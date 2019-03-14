package com.gerson.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 可以被观察的对象
 * Created by gezz on 2019/3/14.
 */
public class PlatformWeather implements Observable {

    List<Observer> observers = new ArrayList<>();


    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void event() {
        for (Observer observer : observers) {
            observer.event();
        }
    }
}
