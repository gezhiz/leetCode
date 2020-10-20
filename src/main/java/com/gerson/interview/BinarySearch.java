package com.gerson.interview;

/**
 * @author gezz
 * @description
 * @date 2020/7/7.
 */
public class BinarySearch {

    public int binarySearch(int[] array, int item, int start, int end) {
        if (start == end) {
            if (array[start] == item){
                return start;
            } else {
                return -1;
            }
        }
        int mid = (start + end) / 2;
        if (array[mid] == item) {
            return mid;
        } else if (array[mid] > item) {
            return binarySearch(array, item, 0, mid - 1);
        } else {
            return binarySearch(array, item, mid + 1, end);
        }
    }

    public int binarySearchNoRecursion(int[] array, int item) {
        if (array == null || array.length <= 0) return -1;
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2;
            if (array[mid] == item) {
                return mid;
            } else if (array[mid] > item) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
