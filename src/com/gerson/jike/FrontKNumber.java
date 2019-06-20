package com.gerson.jike;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author gezz
 * @description 得到数组中第k大的数
 * @date 2019/6/20.
 */
public class FrontKNumber {

    public int getFrontK(List<Integer> array, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int item : array) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(item);
                continue;
            }
            int qItem = priorityQueue.poll();
            priorityQueue.add(qItem > item ? qItem : item);
        }
        return priorityQueue.poll();
    }

    @Test
    public void test() {
        List<Integer> arrays = new ArrayList<>();
        arrays.add(209876);
        arrays.add(1232);
        arrays.add(732);
        arrays.add(109);
        arrays.add(98);
        arrays.add(78);
        arrays.add(65);
        arrays.add(65);
        arrays.add(57);
        arrays.add(38);
        arrays.add(34);
        arrays.add(32);
        arrays.add(32);
        arrays.add(29);
        arrays.add(23);
        arrays.add(6);
        arrays.add(12);
        arrays.add(2);
        System.out.println(getFrontK(arrays,3));
    }
}
