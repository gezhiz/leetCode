package com.gerson.design.observable.test;


import com.gerson.design.observable.EventBus;

/**
 * @author gezz
 * @description
 * @date 2020/5/27.
 */
public class Main {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new Observer1());
        eventBus.register(new Observer2());
        UserService userService = new UserService(eventBus);
        userService.register("gezz","passwd");
    }
}
