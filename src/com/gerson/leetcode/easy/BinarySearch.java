package com.gerson.leetcode.easy;

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
                //未找到
                return -1;
            }
        }
        //注意：计算中位数的方法，
        int mid = (end + start) / 2;
        if (array[mid] == item) {
            return mid;
        } else if (array[mid] < item) {
            //注意start和end数值的选择
            return search1(array, item, mid + 1,end);
        } else {
            //注意start和end数值的选择
            return search1(array, item, start,mid - 1);
        }
    }
    @Test
    public void test1() {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        System.out.println(search1(array,2,0,array.length));
        System.out.println(search(array,2));
    }


    //非递归实现
    public int search(int array[], int item) {
        int start = 0;
        int end = array.length - 1;
        while(start <= end) {
            int mid = (end + start) / 2;
            if (item == array[mid]) {
                return mid;
            } else if(item < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
