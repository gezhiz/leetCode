package com.gerson.juc.ext;

/**
 * ThreadLocal本身是ThreadLocalMap的引用的，这个对象仅仅被Thread对象引用了，如果Thread对象销毁了，那么ThreadLocalMap对象也会被销毁
 * @author gezz
 * @description
 * @date 2020/4/23.
 */
public class NameThreadLocal extends ThreadLocal {
    private String name;

    public NameThreadLocal(String name) {
        if (name == null || name.trim() == "") {

        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "NameThreadLocal{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
