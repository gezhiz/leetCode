package com.gerson.gof.observer;

/**
 * Created by gezz on 2019/3/14.
 */
public class O1 implements Observer {

    Observable observable;
    @Override
    public void event() {
        System.out.println("o1 发现天气变化");
        if (observable != null) {
            System.out.println("o1 发现天气数据：" + observable.getData());
        }
    }

    @Override
    public void setObservable(Observable observable) {
        this.observable = observable;
    }
}
