package com.gerson.bjsxt.singleton;

/**
 * @author gezz
 * @description todo
 * @date 2019/8/15.
 */
public class SingletonInnerClass {

    private SingletonInnerClass() {
    }

    public static class InnerClass {
        private static SingletonInnerClass instance = new SingletonInnerClass();
    }

    public SingletonInnerClass getInstance() {
        return InnerClass.instance;
    }
}
