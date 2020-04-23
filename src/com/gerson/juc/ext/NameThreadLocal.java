package com.gerson.juc.ext;

/**
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
}
