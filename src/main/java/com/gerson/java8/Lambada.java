package com.gerson.java8;

import org.junit.Test;

/**
 * @author gezz
 * @description
 * @date 2020/5/3.
 */
public class Lambada {

    @FunctionalInterface
    interface Function {
        int fun(int a, int b);
    }

    @Test
    public void test1() {
        Function function = (a, b) -> a * b;
        System.out.println(function.fun(2,3));
    }
}
