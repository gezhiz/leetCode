package com.gerson.leetCode.easy;

import org.junit.Test;

/**
 * 二分查找算法，从已经排好序的数组array中查询元素item的索引
 * Created by gezz on 2019/3/17.
 */
public class BinarySearch {

    //递归实现
    public int search1(int array[], int item, int start, int end) {
        if (start == end) {
            if (array[start] == item) {
                return start;
            } else {
                return -1;//未找到
            }
        }
        int mid = (end - start) / 2 + start;//注意：计算中位数的方法，
        if (array[mid] == item) {
            return mid;
        } else if (array[mid] < item) {
            return search1(array, item, mid + 1,end);//注意start和end数值的选择
        } else {
            return search1(array, item, start,mid - 1);//注意start和end数值的选择
        }
    }
    @Test
    public void test1() {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        System.out.println(search1(array,2,0,array.length));
    }


    //非递归实现
}
