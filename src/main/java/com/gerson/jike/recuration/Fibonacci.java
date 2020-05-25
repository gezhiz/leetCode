package com.gerson.jike.recuration;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归处理
 * 斐波那契数列
 * 斐波那契数列：1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 * 如果设F(n）为该数列的第n项（n∈N*），那么这句话可以写成如下形式：:F(n)=F(n-1)+F(n-2)
 * @author gezz
 * @description todo
 * @date 2019/7/19.
 */
public class Fibonacci {

    /**
     * 使用一个hashmap做方法缓存
     * 在多线程场景可以使用ThreadLocal代替HashMap
     *
     */
    private Map<Integer,Integer> cache = new HashMap<>();

    public int f(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n <= 1) {
            return 1;
        }
        int result = f(n - 1) + f(n - 2);
        cache.put(n,result);
        return result;
    }

    @Test
    public void test() {
        for (int i = 0; i < 1000; i++) {
            System.out.print(f(i) + " ");
        }
    }

    /**
     * 非递归的方法：回溯
     * @param n
     * @return
     */
    public void fi(int n) {
        cache.put(0,1);
        cache.put(1,1);
        for (int i = 2; i < n; i++) {
            int value = cache.get(i - 1) + cache.get(i - 2);
            cache.put(i,value);
        }
    }



    @Test
    public void testFi() {
        int n = 1000;
        fi(n);
        for (int i = 0; i < n; i++) {
            System.out.print(cache.get(i) + " ");
        }
    }

}
