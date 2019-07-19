package com.gerson.jike.recuration;

import org.junit.Test;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/19.
 */
public class PowerX {

    /**
     * 普通递归求解
     *
     * @param x
     * @param n
     * @return
     */
    public double power(double x, double n) {
        if (n <= 0) {
            return 1;
        }
        if (n <= 1) {
            return x;
        }
        return x * power(x, n - 1);
    }

    /**
     * 分治求解，时间复杂度O(logn)
     *
     * @param x
     * @param n
     * @return
     */
    public double power1(double x, double n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / power1(x, -n);
        }
        if (n % 2 == 0) {
            //偶数
            return power1(x * x, n / 2);
        }
        return x * power1(x, n - 1);
    }

    @Test
    public void test() {
        double startTime = System.currentTimeMillis();
        System.out.println(power(2, 10));
        double endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime);
        System.out.println(power1(2, 10));
        System.out.println(System.currentTimeMillis() - endTime1);
    }
}
