package com.gerson.jike.recuration;

import org.junit.Test;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/18.
 */
public class Factorial {
    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n -1);
    }

    @Test
    public void test() {
        System.out.println(factorial(4));
    }
}
