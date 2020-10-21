package com.gerson.dstruct.heap;

import org.junit.Test;

/**
 * @author gezz gezhizheng@xiaomi.com
 * @description
 * @date 2020/10/21.
 */
public class HeapTest {

    @Test
    public void testInsert() {
        Heap heap = new Heap(10);
        for (int i = 0; i < 10; i ++) {
            heap.insert(i);
        }
        System.out.println(heap.array.toString());
    }

    @Test
    public void test() {
        System.out.println(1/2);
    }
}
