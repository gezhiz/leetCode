package com.gerson.leetCode.easy;

import org.junit.Test;

/**
 * 求两个数的最大公约数
 * Created by gezz on 2019/3/17.
 */
public class GCD {

    public int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q,r);
    }

    @Test
    public void test() {
        System.out.println(gcd(32,54));
    }
}
