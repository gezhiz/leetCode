package com.gerson.design.strategy;

/**
 * Created by gezz on 2019/3/14.
 */
public class CanFly implements Behavior {
    @Override
    public void fly() {
        System.out.println("can fly !");
    }
}
