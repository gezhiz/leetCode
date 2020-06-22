package com.gerson.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 计算两数之和为n的元素对
 * @author gezz
 * @description
 * @date 2020/6/22.
 */
public class TwoSums {

    @Test
    public void test() {
        int[] array = {1,2,3,4,5,6,7,23,6,7,4,7,8,2,3,1};
        List<Items> itemsList = countTwoSums(array, 6);
        System.out.println(itemsList);
    }

    public class Items {
        public int i,j;

        public Items(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Items{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    public List<Items> countTwoSums(int[] array, int n) {
        Set<Integer> counts = new HashSet<>();
        List<Items> result = new ArrayList<>();
        for (int item : array) {
            int target = n - item;
            if (counts.contains(target)) {
                result.add(new Items(item, target));
            }
            if (!counts.contains(item)) {
                counts.add(item);
            }
        }
        return result;
    }
}
