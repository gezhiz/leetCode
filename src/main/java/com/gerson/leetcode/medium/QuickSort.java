package com.gerson.leetcode.medium;

import org.junit.Test;

/**
 * 快速排序：
 * 1、找选取一个基准点p（比如：最后一个元素）
 * 2、一趟快速排序
 *  目的：把比array[p]的数放到p的左边，比array[p]大的数放到p的右边
 *  方法：双指针，比如：i=0,j=len-2。比基准点p小的数与比基准点大的数进行交换
 * 3、递归思想，
 * 4、复杂度：O(nlogn),n次快速排序，每次快速排序的复杂度为O(logn)
 * Created by gezz on 2019/3/13.
 */
public class QuickSort {
    public void sort(int[] arrays, int start, int end) {
        if (start >= end) {
            return;
        }
        //选取基准点
        int p = end;
        int i = start;
        int j = end - 1;
        while (i < j) {
            if (arrays[i] <= arrays[p]) {
                i++;
            } else if (arrays[j] >= arrays[p]) {
                j--;
            } else {
                swap(arrays,i,j);
            }
        }
        if (arrays[i] > arrays[p]) {
            swap(arrays,p,i);
            //对左半部分进行快速排序
            sort(arrays,0,i - 1);
            //对右半部分进行快速排序
            sort(arrays,i + 1,end);
        } else {
            swap(arrays,p,i + 1);
            //对左半部分进行快速排序
            sort(arrays,0,i);
            //对右半部分进行快速排序
            sort(arrays,i + 2,end);
        }
    }

    public void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    @Test
    public void test() {
        int arrays[] = {1,111,10,4,12,1,6,63,8,7,20,1000,2000,21131,2323,3231,23,42,11,1,2,3,4,5,2,3,4,5,2,5,2,3,2,0};
        sort(arrays,0,arrays.length - 1);
        for (int i : arrays) {
            System.out.print(i + ",");
        }
    }

}
