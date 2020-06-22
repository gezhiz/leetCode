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
            return search1(array, item, mid + 1, end);
        } else {
            //注意start和end数值的选择
            return search1(array, item, start, mid - 1);
        }
    }

    @Test
    public void test1() {
        int[] array = new int[]{1, 3, 3, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8, 9, 10, 11};
        System.out.println(search1(array, 2, 0, array.length));
        System.out.println(search(array, 2));
        System.out.println(searchFirst(array, 5));
        System.out.println(searchFirstOpt(array, 5));
        System.out.println(searchLastOpt(array, 5));
        System.out.println(searchFirstBigger(array, 5));
        System.out.println(searchFirstBiggerOrEqual(array, array.length, 5));
        System.out.println(searchLastSmallerOrEqual(array, 5));
    }


    //非递归实现
    public int search(int array[], int item) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (item == array[mid]) {
                return mid;
            } else if (item < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找第一个item，找到后往前遍历，复杂度偏高，考虑优化
     *
     * @param array
     * @param item
     * @return
     */
    public int searchFirst(int[] array, int item) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (item == array[mid]) {
                int i = mid;
                while (i >= 0 && array[i] == array[mid]) {
                    i--;
                }
                return i + 1;

            } else if (item < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int searchFirstOpt(int[] array, int item) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (item == array[mid]) {
                if (mid - 1 >= 0 && item != array[mid - 1]) {
                    //跟普通的二分查找相比，就是递归的出口发生了变化
                    return mid;
                }
                end = mid - 1;
            } else if (item < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    public int searchLastOpt(int[] array, int item) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (item == array[mid]) {
                if (mid + 1 < array.length && item != array[mid + 1]) {
                    return mid;
                }
                start = mid + 1;
            } else if (item < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int searchFirstBigger(int[] array, int item) {
        int start = 0;
        int end = array.length;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (item == array[mid]) {
                start = mid + 1;
            } else if (item < array[mid]) {
                if (mid - 1 > 0 && array[mid - 1] <= item) {
                    return mid;
                }
                end = mid - 1;

            } else {
                //item > array[mid]
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于或等于value的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int searchFirstBiggerOrEqual(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于或等于value的元素
     * @param array
     * @param value
     * @return
     */
    public int searchLastSmallerOrEqual(int [] array, int value) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (value >= array[mid]) {
                //mid是最后一个或者右边的元素大于value，mid就是最后一个
                if (mid == array.length - 1 || array[mid + 1] > value ) {
                    return mid;
                }
                start = mid + 1;
            } else {
                //value < array[mid]
                end = mid - 1;
            }
        }
        return -1;
    }
}
