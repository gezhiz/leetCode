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
    public double power(double x, int n) {
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
    public double power1(double x, int n) {
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
        //奇数
        return x * power1(x, n - 1);
    }

    /**
     * 分治求解：位运算
     * 例如：
     *  x^10 = (x^2) * x * (x^2)
     * @param x
     * @param n
     * @return
     */
    public double power2(double x, int n) {
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        double pow = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                //如果n的最低二进制位是1(奇数)，奇数的情况下乘x
                pow = pow * x;
            }
            x = x * x;
            //n = n/2  分治：一分为二
            n = n >> 1;
        }
        return pow;
    }

    /**
     * 分治算法
     * @param x
     * @param n
     * @return
     */
    public double power3(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double pow = 1;
        while (n > 0) {
            if (n %2 != 0) {
                pow = pow * x;
            }
            x = x * x;
            n = n / 2;
        }
        return pow;
    }

    @Test
    public void test() {
        double startTime = System.currentTimeMillis();
        System.out.println(power(2, 10));
        double endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime);
        System.out.println(power1(2, 10));
        System.out.println(System.currentTimeMillis() - endTime1);
        System.out.println(power2(2, 10));
        System.out.println(power3(2, 10));
    }
}
