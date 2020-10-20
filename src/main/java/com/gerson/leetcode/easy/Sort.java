package com.gerson.leetcode.easy;

import org.junit.Test;

/**
 * Created by gezz on 2019/2/28.
 */
public class Sort {

    @Test
    public void test() {
//        int[] numbers = new int[] {3,1,0,3,2,1,2,2,46,53,9,23};
//        int numbers[] = {1,111,10,4,12,1,1,1,1,1,6,5,3,2,1,6,63,8,7,20,1000,2000,21131,2323,3231,23,42,11,1,2,3,4,5,2,3,4,5,2,5,2,3,2,0,0};
        int[] numbers = {1,4,1,2,9,10,231,1231,43,23,6,7,7,7,7,7,7,7,7,7};
//        bubbleSort(numbers);
//        selectSort(numbers);
//        insertSort(numbers);
//        mergeSort(numbers, 0, numbers.length - 1);
        quickSort(numbers, 0, numbers.length - 1);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        System.out.println(kthNumber(numbers, 0, numbers.length - 1, 14));
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

    /**
     * 快速排序：原地排序，稳定的排序，时间复杂度O(nlogn)
     * 一次快速排序：选取任意一个元素（比如选取尾部）p作为分区元素，大于等于p的放右边，小于p的放左边
     *      使用双指针，i从start头往后遍历，j从end往前遍历，通过与p进行比较，遇到需要交换的场景则进行交换。
     * 最终i和j相遇,再分别对两边进行递归快速排序
     * @param numbers
     * @param start
     * @param end
     */
    public void quickSort(int[] numbers, int start, int end) {
        if (numbers == null || numbers.length <= 0 || start >= end || start < 0 || end < 0) {
            return;
        }
        int i = partition(numbers, start, end);
        quickSort(numbers, start, i);
        quickSort(numbers, i + 1, end);
    }

    /**
     * 进行一次快速排序，分区操作
     * @param numbers
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] numbers, int start, int end) {
        int i = start, j = end -1, p = end;
        while (i < j) {
            if (numbers[i] <= numbers[p]) {
                i++;
            } else if (numbers[j] > numbers[p]) {
                j--;
            } else {
                //j有可能会比i小，所以后续只能选取i作为分区点
                swap(numbers, i++ , j--);
            }
        }
        //i选取为分区点
        if (numbers[i] > numbers[p]) {
            swap(numbers, i, p);
        }
        return i;
    }

    public void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    /**
     * 获取第K大的数组元素
     * @param numbers
     * @param start
     * @param end
     * @param k
     * @return
     */
    private int kthNumber(int[] numbers, int start, int end, int k) {
        if (numbers == null || numbers.length <= 0 || start >= end || start < 0 || end < 0) {
            return -1;
        }
        int i = partition(numbers, start, end);
        if (i == k - 1) {
            return numbers[i];
        } else if (i > k -1) {
            return kthNumber(numbers, 0, i, k);
        } else {
            return kthNumber(numbers, i + 1, end, k);
        }
    }

}
