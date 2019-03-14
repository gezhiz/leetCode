package com.gerson.designPattern.strategy;

/**
 * 家养的鸭
 * Created by gezz on 2019/3/14.
 */
public class DomeDuck extends AbstractDuck {
    public DomeDuck(Behavior behavior) {
        this.behavior = behavior;
    }
}
