package com.gerson.design.strategy;

/**
 * 把行为抽象成一个接口，然后通过组合的方式注入到类中，行程一种策略
 * Created by gezz on 2019/3/14.
 */
public interface Behavior {
    void fly();
}
