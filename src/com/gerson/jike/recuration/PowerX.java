package com.gerson.jike.recuration;

import org.junit.Test;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/19.
 */
public class PowerX {

    public int power(int x, int n) {
        if (n <= 1) {
            return x;
        }
        return x * power(x,n - 1);
    }

    @Test
    public void test() {
        System.out.println(power(2,10));;
    }
}
