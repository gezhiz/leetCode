package com.gerson.design.proxy;

/**
 * @author gezz
 * @description
 * @date 2020/6/1.
 */
public class SourceObject implements SourceInterface {
    private String name;

    public SourceObject(String name) {
        this.name = name;
    }

    @Override
    public void func(String string) {
        System.out.println("source object " + string + " name: " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
