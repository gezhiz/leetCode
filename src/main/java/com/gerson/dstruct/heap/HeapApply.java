package com.gerson.dstruct.heap;

import org.junit.Test;

/**
 * @author gezz gezhizheng@xiaomi.com
 * @description
 * @date 2020/10/22.
 */
public class HeapApply {

    @Test
    public void testFindMiddleNum() {
        int[] array = {1,3,4,1,2,6,4,2,4,3,2};
        System.out.println(findMiddleNum(array));
    }

    /**
     * 查找中位数
     */
    public int findMiddleNum(int[] array) {
        if (array.length == 0) {
            return -1;
        }
        if (array.length <=2) {
            return array[0];
        }
        int largeTopLength = array.length % 2 == 0 ? array.length/2 : (array.length/2 + 1);

        LargeTopHeap largeTopHeap = new LargeTopHeap(largeTopLength);
        for (int i = 0; i < array.length; i++) {
            if (!largeTopHeap.insert(array[i])) {
                largeTopHeap.removeMax();
                largeTopHeap.insert(array[i]);
            }
        }
        return largeTopHeap.getMaxCount();
    }
}
