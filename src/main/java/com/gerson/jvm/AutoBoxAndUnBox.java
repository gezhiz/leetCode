package com.gerson.jvm;

/**
 * 自动装箱 Integer.valueOf() 使用了IntegerCache 作为缓存
 * @author gezz
 * @description
 * @date 2020/4/7.
 */
public class AutoBoxAndUnBox {
    public static void main(String[] args) {
        Integer a = 1;//Integer.valueOf(1)   (-128,128] 之间的数直接使用SMALL_VALUES[228]常量
        Integer b = 2;//Integer.valueOf(1)   (-128,128] 之间的数直接使用SMALL_VALUES[228]常量
        Integer a1 = new Integer(1);
        Integer a2 = 1;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;//new Integer(321)
        Integer f = 321;//new Integer(321)
        Long g = 3L;

        System.out.println(c == d);//true
        System.out.println(a1 == a);//false
        System.out.println(a == a2);//true
        System.out.println(e == f);//false
        System.out.println(c == (a + b));//true 自动拆箱
        System.out.println(c.equals(a + b));//true
        System.out.println(g == (a + b));//true 自动装箱成Long.valueOf(3)
        System.out.println(g.equals(a + b));//false 数据类型不相同

    }
}
