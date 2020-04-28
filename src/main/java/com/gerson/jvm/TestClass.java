package com.gerson.jvm;

/**
 * @author gezz
 * @description
 * @date 2020/4/6.
 */
public class TestClass {
    private int m;
    public int inc() {
        try {
            return m + 1;
        } catch (Exception e) {
            return 20;
        } finally {
            return 100;
        }
    }
    public int inc(int i) {
        return m + 1;
    }
}
