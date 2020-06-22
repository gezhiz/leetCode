package com.gerson.interview;

import org.junit.Test;

/**
 * 先升序后降序的数组排序问题
 * @author gezz
 * @description
 * @date 2020/6/22.
 */
public class AscendDecendSort {


    @Test
    public void test() {
        int[] array = {1,2,3,4,5,6,7,9,6,3,2,1};
        array = sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    //双指针，外加新建一个数组辅助的方法
    public int[] sort(int[] array) {
        int[] newArray = new int[array.length];
        int index = 0;
        int i =0, j = array.length - 1;
        while (i <= j) {
            if (array[i] >= array[j]) {
                newArray[index++] = array[j];
                j--;
            } else {
                newArray[index++] = array[i];
                i++;
            }
        }
        return newArray;
    }

    public void sort2(int[] array) {

    }
}
