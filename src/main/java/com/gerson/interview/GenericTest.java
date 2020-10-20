package com.gerson.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gezz
 * @description
 * @date 2020/6/27.
 */
public class GenericTest {
    //裸类型导致的类型转换异常
    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        List nakeList = list;
        nakeList.add(new Object());
        //类型转换异常
        Integer item0 = list.get(0);
        System.out.println(item0);
    }
}
