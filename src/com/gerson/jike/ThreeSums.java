package com.gerson.jike;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author gezz
 * @description todo
 * @date 2019/7/5.
 */
public class ThreeSums {

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums,0);
    }

    private List<List<Integer>> threeSum(int[] nums, int k) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(k - (nums[i] + nums[j]))) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add(k - (nums[i] + nums[j]));
                    result.add(item);
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {-4, -1, -1, 0, 1, 2};
        List<List<Integer>> result = threeSum(nums, 0);
        for (List<Integer> items : result) {
            for (Integer item : items) {
                System.out.print(item + " ");
            }
            System.out.println("");
        }
    }

}
