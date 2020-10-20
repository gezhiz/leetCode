package com.gerson.interview;

import org.junit.Test;

/**
 * @author gezz
 * @description
 * @date 2020/7/7.
 */
public class SortInterview {


    @Test
    public void test() {
        int[] array = {1,4,1,2,9,10,231,1231,43,23,6,7,7,7,7,7,7,7,7,7};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
    /**
     * i记录冒泡次数
     * j索引进行两两比较
     * isExchange 在一次冒泡中，如果没有发生数据交换，则排序已经完成
     * @param array
     */
    public void bubbleSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {

            boolean isExchange = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isExchange = true;
                }
            }
            if (isExchange == false) {
                break;
            }
        }
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 一次快速排序
     * @param array
     * @return
     */
    public int partition(int[] array, int start, int end) {
        int p = end;
        int i = start, j = end - 1;
        while (i < j) {
            if (array[i] <= array[p]) {
                i++;
            } else if (array[j] >= array[p]) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        if (array[i] > array[p]) {
            swap(array,i, p);
        }
        return i;
    }

    public void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int partition = partition(array, start, end);
        quickSort(array, start, partition);
        quickSort(array, partition + 1, end);
    }
}
