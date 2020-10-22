package com.gerson.dstruct.heap;

import com.google.gson.Gson;
import org.junit.Test;

/**
 * @author gezz gezhizheng@xiaomi.com
 * @description
 * @date 2020/10/21.
 */
public class HeapTest {

    @Test
    public void testInsert() {
        LargeTopHeap heap = new LargeTopHeap(10);
        for (int i = 0; i < 10; i ++) {
            heap.insert(i);
        }
        System.out.println(new Gson().toJson(heap.array));
        heap.removeMax();
        System.out.println(new Gson().toJson(heap.array));
    }

    @Test
    public void test() {
        Integer[] array = {0,2,1,4,5,2,1,2,8,6,4,2,7,9,4};
        LargeTopHeap.heapSort(array, array.length - 1);
        System.out.println(new Gson().toJson(array));
    }

    @Test
    public void testPlus() {
        int count = 1;
        System.out.println(++count);
    }
}
