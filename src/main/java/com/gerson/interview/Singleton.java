package com.gerson.interview;

/**
 * @author gezz
 * @description
 * @date 2020/6/22.
 */
public class Singleton {

    public volatile static Singleton singleton = null;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
