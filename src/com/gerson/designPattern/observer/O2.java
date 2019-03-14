package com.gerson.designPattern.observer;

/**
 * Created by gezz on 2019/3/14.
 */
public class O2 implements Observer {

    @Override
    public void event() {
        System.out.println("o2 发现天气变化");
    }
}
