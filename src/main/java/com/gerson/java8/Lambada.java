package com.gerson.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * @author gezz
 * @description
 * @date 2020/5/3.
 */
public class Lambada {

    private static int[] ints = {1,2,3,4,5,6,7};
    private static double[] doubles = {1,2,3,4,5,6,7};

    @FunctionalInterface
    interface Function {
        int fun(int a, int b);
    }

    @Test
    public void test1() {
        Function function = (a, b) -> a * b;
        System.out.println(function.fun(2,3));
    }

    @Test
    public void test2() {
        for (int i : ints) {
            System.out.println(i);
        }
    }

    @Test
    public void test3() {

        Arrays.stream(ints).forEach(value -> System.out.println(value));
    }

    @Test
    public void test4() {
        //方法引用
        IntConsumer intConsumer = System.out::println;
        IntConsumer errIntConsumer = System.err::println;
        Arrays.stream(ints).forEach(intConsumer.andThen(errIntConsumer));


        DoubleConsumer doubleConsumer = System.out::println;
        Arrays.stream(doubles).forEach(doubleConsumer);

    }

}
