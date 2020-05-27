package com.gerson.design.observable.test;

import com.gerson.design.observable.EventBus;

/**
 * @author gezz
 * @description
 * @date 2020/5/27.
 */
public class UserService {

    private EventBus eventBus;

    public UserService(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void register(String user, String passwd) {
        doRegister();
        eventBus.post(new RegisterEvent(user, passwd));
    }

    private void doRegister() {
        System.out.println("doRegister()");
    }
}
