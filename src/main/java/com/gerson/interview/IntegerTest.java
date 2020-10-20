package com.gerson.interview;

import org.junit.Test;

/**
 * @author gezz
 * @description
 * @date 2020/6/27.
 */
public class IntegerTest {
    public static void main(String[] args) {
        Float f1 = 1f;
        Float f2 = 1f;
        //常量池
        Integer a = 1;
        //常量池
        Integer b = 2;
        //常量池
        Integer c = 3;
        //常量池
        Integer d = 3;
        //不在常量池
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        //常量池，true
        System.out.println(c == d);
        //false
        System.out.println(e == f);
        //true 常量池
        System.out.println(c == (a + b));

        //浮点类型没有常量池
        System.out.println(f1 == f2);
        //equals方法比较值大小
        System.out.println(f1.equals(f2));
        //true equals比较值大小
        System.out.println(c.equals(a + b));
        //长整形也有常量池 true
        System.out.println(g == (a + b));

        //不同的数据类型，直接返回false
        System.out.println(g.equals(a + b));

        //false new指令创建的对象不使用常量池
        System.out.println(new Integer(1) == new Integer(1));
    }

    @Test
    public void testValue() {
        int num1 = 10;
        int num2 = 20;

        swapVaue(num1, num2);

        //num1 = 10   num2 = 20   java方法只能传递值,针对引用类型，传递的是引用类型的地址,引用类型本身不会发生变化
        // 但是引用类型 内部的变量能够发生变化
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);


        Integer ref1 = new Integer(10);
        Integer ref2 = new Integer(20);
        swapReferenceInteger(ref1, ref2);
        //ref1 = 10  ref2 = 20  包装类型也是一样的
        System.out.println("ref1 = " + ref1);
        System.out.println("ref2 = " + ref2);


        String str1 = "str10";
        String str2 = "str20";
        swapReferenceString(str1, str2);
        //ref1 = 10  ref2 = 20  String也是一样的
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        A a1 = new A(10);
        A a2 = new A(20);
        swapClass(a1, a2);
        //ref1 = 10  ref2 = 20  String也是一样的
        System.out.println("a1 = " + a1.value);
        System.out.println("a2 = " + a2.value);

        swapClassValue(a1, a2);
        //100  200  只有引用类型内部的值能够发生变化，方法参数本身的引用不能发生变化
        System.out.println("a1 = " + a1.value);
        System.out.println("a2 = " + a2.value);
    }

    public void swapVaue(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public void swapReferenceInteger(Integer a, Integer b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public void swapReferenceString(String a, String b) {
        String temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }


    public void swapClass(A a, A b) {
        A temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a.value);
        System.out.println("b = " + b.value);
    }



    public void swapClassValue(A a, A b) {
        a.value = 100;
        b.value = 200;

        System.out.println("a = " + a.value);
        System.out.println("b = " + b.value);
    }

    public static class A {
        public Integer value;

        public A(Integer value) {
            this.value = value;
        }
    }
}
