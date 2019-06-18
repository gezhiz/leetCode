package com.gerson.leetcode.medium;

import org.junit.Test;

/**
 * Created by gezz on 2019/3/13.
 */
public class QuickSort {
    public void sort(int[] arrays, int start, int end) {
        if (start >= end) {
            return;
        }
        //选取基准点
        int p = arrays[end];
        int i = start;
        int j = end - 1;
        while (i < j) {
            if (arrays[i] <= p) {
                i++;
            } else if (arrays[j] >= p) {
                j--;
            } else {
                swap(arrays,i,j);
            }
        }
        if (arrays[i] > p) {
            swap(arrays,end,i);
            sort(arrays,0,i - 1);//对左半部分进行快速排序
            sort(arrays,i + 1,end);//对右半部分进行快速排序
        } else {
            swap(arrays,end,i + 1);
            sort(arrays,0,i);//对左半部分进行快速排序
            sort(arrays,i + 2,end);//对右半部分进行快速排序
        }
    }

    public void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    @Test
    public void test() {
        int arrays[] = {1,111,10,4,12,1,6,63,8,7,20,1000,2000,21131,2323,3231,23,42,11,1,2,3,4,5,2,3,4,5,2,5,2,3,2};
        sort(arrays,0,arrays.length - 1);
        for (int i : arrays) {
            System.out.print(i + ",");
        }
    }

}
