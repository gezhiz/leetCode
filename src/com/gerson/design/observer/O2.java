package com.gerson.design.observer;

/**
 * Created by gezz on 2019/3/14.
 */
public class O2 implements Observer {

    private Observable observable;

    @Override
    public void event() {
        System.out.println("o2 发现天气变化");
        System.out.println("o2 发现天气数据：" + observable.getData());
    }

    @Override
    public void setObservable(Observable observable) {
        this.observable = observable;
    }
}
