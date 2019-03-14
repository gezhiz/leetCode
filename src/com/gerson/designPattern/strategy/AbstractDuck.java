package com.gerson.designPattern.strategy;

/**
 * Created by gezz on 2019/3/14.
 */
public abstract class AbstractDuck {

    Behavior behavior;//使用接口作为一种策略，让子类实现

    void fly() {
        behavior.fly();
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

}
