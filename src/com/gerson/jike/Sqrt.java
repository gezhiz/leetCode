package com.gerson.jike;

import org.junit.Test;

/**
 * 求解 n 的二次根
 * 因为y = x * x 是单调递增的，所以可以使用二分法
 * @author gezz
 * @description
 * @date 2020/3/27.
 */
public class Sqrt {

    public double sqrt(double start, double end, double n) {
        double mid = (end + start) / 2;
        if (mid * mid == n) {
            return mid;
        } else if ( Math.abs(mid * mid - n ) <= 0.0000000000001d) {
            return mid;
        } else if (mid * mid > n){
            return sqrt(start, mid, n);
        } else {
            return sqrt(mid, end, n);
        }
    }

    @Test
    public void test() {
        double n = 9D;
        System.out.println(sqrt(0, n, n));
    }
}
