package com.gerson.gof.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 可以被观察的对象
 * Created by gezz on 2019/3/14.
 */
public class PlatformWeather implements Observable {

    List<Observer> observers = new ArrayList<>();
    private String data = "37 C";


    @Override
    public void register(Observer observer) {
        observers.add(observer);
        observer.setObservable(this);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.event();//通知
        }
    }

    @Override
    public String getData() {
        return data;
    }
}
