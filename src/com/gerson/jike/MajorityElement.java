package com.gerson.jike;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 示例 1:

 输入: [3,2,3]
 输出: 3
 示例 2:

 输入: [2,2,1,1,1,2,2]
 输出: 2

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/majority-element
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {

    @Test
    public void test() {
        int[] nums = {10,2,10,2,3,7};
        System.out.println(majorityElement(nums,0,nums.length -1));
        System.out.println(majorityElement2(nums));
    }
    /**
     * 分治算法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = (end-start)/2 + start;
        int leftResult = majorityElement(nums,start,mid);
        int rightResult = majorityElement(nums,mid + 1, end);
        if (leftResult == rightResult) {
            //左右两边都是同一个数，则这个就是本次递归出现次数最多的那个数
            return leftResult;
        } else {
            //在上一级递归中查找出现次数最大的那个数
            int leftCount = countInRange(nums, leftResult, start, end);
            int rightCount = countInRange(nums, rightResult, start, end);

            return leftCount > rightCount ? leftResult : rightResult;
        }

    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * 使用map求解
     * @param nums
     * @return
     */
    private Integer majorityElement2(int[] nums) {
        int n = nums.length / 2;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null){
                count = 0;
            }
            if (count >= n - 1) {
                return nums[i];
            }
            map.put(nums[i], count + 1);
        }
        return null;
    }

}
