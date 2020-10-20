package com.gerson.jvm;

/**
 * @author gezz
 * @description
 * @date 2020/4/6.
 */
public class TestClass {
    private int x;
    public int inc() {
        try {
            return x + 1;
        } catch (Exception e) {
            return 20;
        } finally {
            return 100;
        }
    }
    public int inc(int i) {
        return x + 1;
    }
}
