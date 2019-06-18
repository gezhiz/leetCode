package com.gerson.leetcode.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gezz on 2019/2/28.
 */
public class MaxLength {

    /**
     * 斐波那契数列实现
     * 1 1 2 3 5 8 13 21 34
     */

    @Test
    public void testFeb() {
        int n = 20;
        for (int i = 1; i < n; i++) {
            System.out.print(getFebItem(i) + " ");
        }
    }

    public int getFebItem(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0 || n == 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int sum = 0;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {//第n个元素，需要记录n-1次
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }


    /**
     * ﻿
     给定一个字符串“a b webd a  agesg aeg ewe sdse ddd age ewewr age”，输出每一个字符串的出现的次数，如：
     age:2
     a:2
     b:1
     aeg:1
     */
    @Test
    public void testPrintCount() {
        Map<String,Integer> result = printCount("a b webd a ewewr   agesg aeg ewe sdse ddd age ewewr age  age");
        for (Map.Entry<String,Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    public Map<String,Integer> printCount(String source) {
        Map<String, Integer> result = new HashMap<>();
        String[] sources = source.split("\\W+");
        for (String word : sources) {
            Integer count = result.get(word);
            if (count != null) {
                count++;
                result.put(word,count);
            } else {
                result.put(word,1);
            }
        }
        return result;
    }

    @Test
    public void main() {
        String source = "a bc defg ghi j k l mn op q00000";
        char[] chars = source.toCharArray();
        int result = 0;
        int lastLength = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                lastLength++;
            } else {
                if (lastLength > result) {
                    result = lastLength;
                }
                lastLength = 0;
            }
        }
        System.out.println("结果：" + result);
    }


    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     要求算法的时间复杂度为 O(n)。
     示例:
     输入: [100, 4, 200, 1, 3, 2]
     输出: 4
     解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */
    @Test
    public void testLongestConsecutive() {
        int[] chars = {1, 2, 3, 4 , 6 ,32,234,5};
        System.out.println(longestConsecutive(chars));
    }
    public int longestConsecutive(int[] nums) {
        /**
         利用一个map保存各个候选最长序列的左右边界及其长度, 例如{1,2,3,4,5}中数字1和5对应的长度都是5
         依次遍历每个数num, 如果map中存在num-1或num+1则更新num所处的序列长度及其边界值
         **/
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            if(!map.containsKey(num)) {
                // 获取左右边界对应的序列长度
                int left = map.getOrDefault(num-1, 0);
                int right = map.getOrDefault(num+1, 0);
                // 更新最长序列长度
                int len = left+right+1;//左右都有的情况下，len是1；
                ret = len > ret ? len : ret;
                map.put(num-left, len);
                map.put(num+right, len);
                // 把num加入map中防止重复判断(关键在于将num加入keyset中, value可以是任意值)
                map.put(num, len);
            }
        }
        return ret;
    }
}
