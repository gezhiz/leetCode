package com.gerson.dstruct.heap;

/**
 * 大顶堆
 * 堆是一种完全二叉树的结构，可以使用数组来存储,数组下标从1开始
 * 数组中下标为 i 的节点的左子节点，就是下标为 i*2 的节点，右子节点就是下标为 i*2+1 的节点，父节点就是下标为 i/2​ 的节点
 *
 * @author gezz gezhizheng@xiaomi.com
 * @description
 * @date 2020/10/20.
 */
public class LargeTopHeap {
    /**
     * 堆中存储的数据，下标从1开始
     */
    public Integer[] array;
    /**
     * 堆中已经存放的数据
     */
    public Integer count;
    /**
     * 堆最大容量
     */
    public Integer maxCount;

    public LargeTopHeap(Integer capacity) {
        array = new Integer[capacity + 1];
        maxCount = capacity;
        count = 0;
    }



    /**
     * 向堆中插入一个元素，时间复杂度O(Logn)，从下往上堆化
     * @param data
     */
    public boolean insert(Integer data) {
        if (count >= maxCount) {
            return false;
        }
        array[++count] = data;
        //从下往上 进行堆化操作,把更大的数放在前面
        Integer i = count;
        while (i / 2 > 0 && array[i] > array[i/2]) {
            swap(this.array, i, i/2);
            i = i / 2;
        }
        return true;
    }


    /**
     * 从上往下依次堆化
     * 堆化 索引位置为： count/2   ~  1 的数据
     * @param a
     * @param count 数组数据量
     */
    public static void buildHeap(Integer a[], Integer count) {
        for (Integer i = count / 2; i >= 1; i--) {
            heapify(a, count, i);
        }
    }

    public static void heapSort(Integer a[], Integer count) {
        buildHeap(a, count);
        Integer k = count;
        //删除堆顶元素  （删除堆顶元素的逻辑：用堆内最后一个元素替换堆顶元素），然后再重新把k排除构建堆
        while (k >= 1) {
            //堆顶元素和最后一个元素互换
            swap(a, k, 1);
            //针对剩余元素重新构建堆
            k--;
            heapify(a, k, 1);
        }
    }

    /**
     * 用堆内最后一个元素替换堆顶元素，然后从上往下进行堆化,时间复杂度O(Logn)
     * @return
     */
    public Integer removeMax() {
        if (count == 0) {
            return null;
        }
        Integer max = array[1];
        array[1] = array[count];
        array[count] = -1;
        count--;
        //从上往下堆化
        heapify(array, count, 1);
        return max;
    }

    public Integer getMaxCount() {
        if (count >= 0) {
            return array[1];
        }
        return null;
    }

    /**
     * 从needEx位置开始向下进行堆化操作
     * @param array
     * @param count 数组中最大堆的位置
     * @param i 开始堆化的索引  i > 0
     */
    private static void heapify(Integer[] array, Integer count, Integer i) {
        if (i < 0) {
            throw new IllegalArgumentException("i must be bigger than 0");
        }
        while (true) {
            //每一轮循环都找到最大的数的位置
            Integer maxPos = i;
            //与左子节点进行比较
            if (i * 2 <= count && array[maxPos] < array[2 * i]) {
                maxPos = i * 2;
            }
            //与右子节点
            if (i * 2 + 1 <= count && array[maxPos] < array[2 * i + 1]) {
                maxPos = i * 2 + 1;
            }

            if (maxPos == i) {
                break;
            }
            swap(array, maxPos, i);
            i = maxPos;
        }
    }

    public static void swap(Integer[] array, Integer i, Integer j) {
        Integer tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
