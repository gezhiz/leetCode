package com.gerson.leetCode.easy;

import org.junit.Test;

/**
 * Created by gezz on 2019/2/28.
 */
public class Sort {

    @Test
    public void test() {
        int[] numbers = new int[] {3,1,0,3,2,1,2,2,46,53,9,23};
//        bubbleSort(numbers);
        insertSort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    /**
     *  冒泡排序
     *  基本思想：比较相邻的两个元素，如果第一个比第二个大，就调换
     *      i记录的是需要冒泡的次数，j是进行冒泡的元素的索引
     *      这样做，每i次排序过后，第size-i个元素的位置是正确的
     */

    public void bubbleSort(int[] numbers) {
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {//冒泡排序的次数
            for (int j = 0; j < size -i - 1; j++) {//排序的索引
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
         }
    }


    /**
     * 插入排序
     * ﻿基本思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。
     * @param numbers
     */
    public void insertSort(int[] numbers) {
        int size = numbers.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers[j] < numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}
