package com.gerson.jike;

import org.junit.Test;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/19.
 */
public class MajorityElement {

    @Test
    public void test() {
        int[] nums = {10,3,4,5,6,2,4,6,7,9,10,10,2,3,4,5,6,7};
        System.out.println(majorityElement(nums,0,nums.length -1));
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
        if (leftResult >= rightResult) {
            return leftResult;
        }
        int leftCount = countInRange(nums, leftResult, start, end);
        int rightCount = countInRange(nums, rightResult, start, end);

        return leftCount > rightCount ? leftResult : rightResult;
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

}
