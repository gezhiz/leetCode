package com.gerson.leetcode.easy;

import org.junit.Test;

/**
 * 编写一个方法，颠倒数组的元素
 * Created by gezz on 2019/3/17.
 */
public class ReversalArray {

    public int[] reversal(int array[]) {
        int len = array.length - 1;//length = 10   len = 9     len/2 = 4   排序 0-3
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[len - i];
            array[len - i] = array[i];
            array[i] = temp;
        }
        return array;
    }

    @Test
    public void test() {
        int[] array = reversal(new int[]{1,2,3,4,5,6,7,8,9,10});
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
