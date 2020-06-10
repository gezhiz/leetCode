package com.gerson.leetcode.easy;

import org.junit.Test;

/**
 * Created by gezz on 2019/2/28.
 */
public class Sort {

    @Test
    public void test() {
        int[] numbers = new int[] {3,1,0,3,2,1,2,2,46,53,9,23};
//        bubbleSort(numbers);
//        selectSort(numbers);
//        insertSort(numbers);
        mergeSort(numbers, 0, numbers.length - 1);
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
        //冒泡排序的次数
        for (int i = 0; i < size - 1; i++) {
            //标记，如果某一次冒泡过程中，没有发生交换，则排序已经完成
            boolean flag = false;
            for (int j = 0; j < size -i - 1; j++) {
                //进行一次冒泡
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
         }
    }


    /**
     * 选择排序
     * ﻿基本思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。
     * @param numbers
     */
    public void selectSort(int[] numbers) {
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

    /**
     * 插入排序
     * 将数据分成已排序区域和未排序区域，在未排序区域选择数据插入到已排序区域
     * @param numbers
     */
    public void insertSort(int[] numbers) {
        int size = numbers.length;
        if (size <= 0) {
            return;
        }
        //默认情况下，第一个元素为有序的区域。从数组的第二个元素开始是无需的区域
        for (int i = 1; i < size; i++) {
            int value = numbers[i];
            //查找该插入的位置，并且移动数据空出该位置
            int j = i - 1;
            for (; j >= 0; --j) {
                if (numbers[j] > value) {
                    numbers[j + 1] = numbers[j];
                } else {
                    break;
                }
            }
            numbers[j + 1] = value;
        }
    }

    /**
     * 归并排序
     * @param numbers
     * @param start
     * @param end
     */
    public void mergeSort(int[] numbers, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(numbers, start, mid);
        mergeSort(numbers, mid + 1, end);
        //合并start-mid, mid+1-end 两端数组
        int i = start, j = mid + 1;
        int[] tmpArray = new int[end - start + 1];
        int tmp = 0;
        while (i <= mid || j <= end) {
            if (i <= mid && j <= end) {
                if (numbers[i] <= numbers[j]) {
                    tmpArray[tmp++] = numbers[i++];
                } else {
                    tmpArray[tmp++] = numbers[j++];
                }
            } else if (i <= mid) {
                //处理剩余的数据
                tmpArray[tmp++] = numbers[i++];
            } else if (j <= end) {
                //处理剩余的数据
                tmpArray[tmp++] = numbers[j++];
            }
        }
        //把tmpArray的数据拷贝到tmpArray
        for (int p = 0, q = start; p < tmpArray.length; p++, q++) {
            numbers[q] = tmpArray[p];
        }
    }
}
