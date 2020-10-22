package com.gerson.dstruct.heap;

import com.google.gson.Gson;

/**
 * @author gezz gezhizheng@xiaomi.com
 * @description
 * @date 2020/10/22.
 */
public class SmallTopHeap {
    private int[] array;
    private int count;
    private int capacity;

    public SmallTopHeap(int capacity) {
        array = new int[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }

    /**
     *
     * @param item
     * @return 插入的位置
     */
    public int insert(int item) {
        if (count >= capacity) {
            return -1;
        }
        int i = ++count;
        array[count] = item;
        //从下往上堆化
        while (i/2 >= 1 && array[i] < array[i/2]) {
            swap(array, i, i/2);
            i = i/2;
        }
        return i;
    }

    public int removeTop() {
        if (count <= 0) {
            return -1;
        }
        int result = array[1];
        array[1] = array[count];
        array[count] = -1;
        //从上往下堆化
        count--;
        heapify(array, count, 1);

        return result;
    }

    private void heapify(int[] array, int count, int root) {
        while (true) {
            int minPos = root;
            if (2*root <= count && array[2*minPos] < array[minPos]) {
                minPos = 2*root;
            }
            if (2*root + 1 <= count && array[2*root + 1] < array[minPos]) {
                minPos = 2*root + 1;
            }
            if (minPos == root) {
                break;
            }
            swap(array,minPos,root);
            root = minPos;
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        SmallTopHeap smallTopHeap = new SmallTopHeap(9);
        for (int i = 1; i < 10; i++) {
            smallTopHeap.insert(i);
        }
        System.out.println(new Gson().toJson(smallTopHeap.array));
        smallTopHeap.removeTop();
        smallTopHeap.removeTop();
        smallTopHeap.removeTop();
        System.out.println(new Gson().toJson(smallTopHeap.array));
        System.out.println(new Gson().toJson(smallTopHeap.count));
    }
}
