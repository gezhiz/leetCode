package com.gerson.design.observer;

/**
 * 观察者接口
 * Created by gezz on 2019/3/14.
 */
public interface Observer {
    void event();
    void setObservable(Observable observable);
}
