package com.gerson.leetcode.others;

import org.junit.Test;

/**
 * Created by gezz on 2019/3/15.
 */
public class StringTest {

    @Test
    public void test() {
        String s1 = "1";//使用双引号的字符串，直接进入常量池
        String s2 = "1";
        System.out.println(s1 == s2);//true:s1 s2 均内容指向常量"1"
    }

    @Test
    public void test2() {
        String s1 = new String("1");
        String s2 = "1";
        System.out.println(s1 == s2);//false,s1指向匿名的String对象，再指向常量"1";而s2直接内容指向常量"1"
    }

    @Test
    public void test3() {
        String s1 = new String("1");
        s1.intern();//把"1"放入常量池（在方法区中，1.7之后的版本，方法区在堆中;1.8之后的版本，常量池不在堆中，而是在元数据区）
        String s2 = "1";
        System.out.println(s1 == s2);//false s1指向匿名的String对象，再指向常量"1";而s2直接内容指向常量"1";  1.7版本的jdk是true
    }

    @Test
    public void test4() {
        String s1 = "1" + "1";
        String s2 = "11";
        System.out.println(s1 == s2);//true s1和s2都是值引用到"11"
    }

    @Test
    public void test5() {
        String s1 = new String("1") + new String("1");//s1 会生成匿名String引用，指向"11"
        String s2 = "11";
        System.out.println(s1 == s2);//false
    }


    @Test
    public void test6() {
        String s1 = new String("1") + new String("1");//s1 会生成匿名String引用，指向"11"
        s1.intern();
        String s2 = "11";
        System.out.println(s1 == s2);//false
    }
}
