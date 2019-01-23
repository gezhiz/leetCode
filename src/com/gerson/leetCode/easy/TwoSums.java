package com.gerson.leetCode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 解答方案2，3中，主要是采用空间换取时间的方法，采用hashmap巧妙的解答了此算法
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 Example:
 Given nums = [2, 7, 11, 15], target = 9,
 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 * Created by gezz on 2019/1/23.
 */
public class TwoSums {
    // 简单的方法
    public static int[] twoSum1(int[] nums, int target) {
        int numLength = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < numLength; i++) {
            for (int j = i; j < numLength;j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                    break;
                }
            }
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int numLength = nums.length;
        int[] result = new int[2];
        Map<Integer,Integer> numsMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numLength; i++) {
            numsMap.put(nums[i],i);
        }
        for (int i = 0; i < numLength; i++) {
            int need = target - nums[i];
            if (numsMap.containsKey(need)) {
                return new int[]{need,nums[i]};
            }
        }
        return result;
    }

    public static int[] twoSum3(int[] nums, int target) {
        int numLength = nums.length;
        int[] result = new int[2];
        Map<Integer,Integer> numsMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numLength; i++) {
            int need = target - nums[i];
            if (numsMap.containsKey(need)) {
                return new int[]{need,nums[i]};
            }
            numsMap.put(nums[i],i);
        }
        return result;
    }



    public static void main(String args[]) {
        int[] nums = {2, 11, 1,5,5,7};

        int[] result = twoSum1(nums,9);
        System.out.println(result[0]);
        System.out.println(result[1]);

        int[] result2 = twoSum1(nums,9);
        System.out.println(result2[0]);
        System.out.println(result2[1]);

        int[] result3 = twoSum1(nums,9);
        System.out.println(result3[0]);
        System.out.println(result3[1]);
    }

}
