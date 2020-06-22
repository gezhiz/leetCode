package com.gerson.interview;

import org.junit.Test;

/**
 * 快速排序的思想，递归找到第k大的数.
 * 如果要找到倒数第k大的数，也可以做
 * @author gezz
 * @description
 * @date 2020/6/22.
 */
public class TopK {

    @Test
    public void test() {
        int[] array = {2,5,6,8,3,5,7,9,32,123,8,5,4,3};
        int topK = topK(array, 8);
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println(topK);
    }

    public int topK(int[] array, int k) {
        if (array == null || array.length < k) {
            return -1;
        }
        return helpTopK(array, 0, array.length - 1, k);

    }
    private int helpTopK(int[] array, int start, int end, int k) {
        int i = partition(array, start, end);
        if (i == k - 1) {
            return array[i];
        } else if (i < k - 1) {
            return helpTopK(array, i + 1, end, k);
        } else {
            // i > k - 1
            return helpTopK(array, start, i - 1, k);
        }
    }

    /**
     * 进行一次快速排序
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] array, int start, int end) {
        int p = end;
        int i = start, j = end - 1;
        while (i <= j) {
            if (array[i] < array[p]) {
                i++;
            } else if (array[j] >= array[p]){
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        if (array[i] > array[p]) {
            swap(array, i, p);
        }
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
