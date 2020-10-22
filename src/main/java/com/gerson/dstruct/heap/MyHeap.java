package com.gerson.dstruct.heap;

import com.google.gson.Gson;

/**
 * 手动写一个堆
 * @author gezz gezhizheng@xiaomi.com
 * @description
 * @date 2020/10/22.
 */
public class MyHeap {
    private Integer[] array;
    private int count;
    private int capacity;

    public MyHeap(int capacity) {
        array = new Integer[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public boolean insert(int item) {
        //判断容量
        if (count >= capacity) {
            return false;
        }
        //在尾部插入item
        int i = ++count;
        array[i] = item;
        while (i/2 > 0 && array[i/2] < array[i]) {
            swap(array, i, i/2);
            i = i/2;
        }
        //从下往上堆化
        return true;
    }

    private void swap(Integer[] array, Integer i, Integer j) {
        Integer tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public Integer removeMax () {
        //判断容量
        if (count == 0) {
            return null;
        }
        //替换换堆顶为底部元素
        int result = array[1];
        array[1] = array[count];
        //从上往下进行堆化
        heapify(array, count, 1);
        return result;
    }

    /**
     * 从位置i开始堆化
     * @param array
     * @param count 堆的实际大小
     * @param i 开始堆化的位置
     */
    private void heapify(Integer[] array, int count, int i) {
        while (true) {
            int maxPos = i;
            if (2 * i <= count && array[maxPos] < array[2 * i]) {
                maxPos = 2 * i;
            }
            if (2 * i + 1 <= count && array[maxPos] < array[2 * i + 1]) {
                maxPos = 2 * i + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(array, maxPos, i);
            i = maxPos;
        }
    }

    /**
     * 堆排序：原地排序
     * @param array
     * @param capacity
     */
    public void heapSort(Integer[] array, int capacity) {
        //把数组进行堆化
        for (int i = capacity / 2; i >= 1; i--) {
            heapify(array, capacity, i);
        }
        int k = capacity;
        //把堆顶移动到k
        while (k >= 1) {
            swap(array, k, 1);
            k--;//堆容量减少1
            //从上到下依次堆化
            heapify(array, k, 1);
        }

    }


    public static void main(String[] args) {
        MyHeap heap = new MyHeap(9);
        for (int i = 1; i <= 9; i++) {
            heap.insert(i);
        }
        System.out.println(new Gson().toJson(heap.array));

        Integer[] array = {-1,1,2,3,4,5,6,7,8,9};
        heap.heapSort(array, 9);
        System.out.println(new Gson().toJson(array));
    }




}
