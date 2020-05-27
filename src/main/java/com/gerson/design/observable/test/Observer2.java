package com.gerson.design.observable.test;

import com.gerson.design.observable.Subscribe;

/**
 * @author gezz
 * @description
 * @date 2020/5/27.
 */
public class Observer2 {

    @Subscribe
    public void subscribe(RegisterEvent registerEvent) {
        System.out.println("Observer2 subscribe: " + registerEvent);
    }
}
