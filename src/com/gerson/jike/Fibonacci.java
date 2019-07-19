package com.gerson.jike;

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
    private Map<Integer,Integer> resultMap = new HashMap<>();

    public int f(int n) {
        if (resultMap.containsKey(n)) {
            return resultMap.get(n);
        }
        if (n <= 2) {
            return 1;
        }
        int result = f(n - 1) + f(n - 2);
        resultMap.put(n,result);
        return result;
    }

    @Test
    public void test() {
        for (int i = 1; i < 1000; i++) {
            System.out.print(f(i) + " ");
        }
    }
}
