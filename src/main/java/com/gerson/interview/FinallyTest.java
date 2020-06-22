package com.gerson.interview;

/**
 * @author gezz
 * @description
 * @date 2020/6/22.
 */
public class FinallyTest {
    public static class A {
        public int a;
    }

    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(test1());
        System.out.println(test2().a);
        System.out.println(test3());
    }

    //return 2
    public static int test() {
        int x = 1;
        try {
            x++;
            return x;
        } finally {
            ++x;
        }
    }


    //return 3
    public static int test1() {
        int x = 1;
        try {
            x++;
            return x;
        } finally {
            ++x;
            //finally语句块中的return会覆盖try 内部的return块
            return x;
        }
    }

    // return 3
    //返回的是引用对象，引用类型表示的是对象的地址，所以此处也是3
    public static A test2() {
        A a = new A();
        a.a = 1;
        try {
            a.a++;
            return a;
        } finally {
            //finally语句在return语句后面执行，但是返回的是对象的地址，所以调用方拿到的是A对象的地址，值是3
            a.a++;
        }
    }

    //return 3
    public static int test3() {
        int a = 1;
        try {
            a++;
            throw new Exception();
        } catch (Exception e) {
            a++;
            return a;
        } finally {
            a++;
        }
    }
}
