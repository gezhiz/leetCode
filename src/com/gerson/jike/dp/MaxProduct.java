package com.gerson.jike.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。

  

 示例 1:

 输入: [2,3,-2,4]
 输出: 6
 解释: 子数组 [2,3] 有最大乘积 6。
 示例 2:

 输入: [-2,0,-1]
 输出: 0
 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * @author gezz
 * @description
 * @date 2020/3/30.
 */
public class MaxProduct {

    @Test
    public void test() {
        int[] nums = {2,3,-2,-4};
        System.out.println(maxProduct(nums));
    }
    /**
     * 动态规划求解
     * @param nums   表示传入的数组
     */
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int curMa = curMax * num;
            int curMi = curMin * num;
            curMax = max(curMa,curMi, num);
            curMin = min(curMa,curMi, num);
            result = Math.max(result, curMax);
        }
        return result;

    }

    private int max(int n1, int n2, int n3) {
        return Math.max(Math.max(n1,n2),n3);
    }

    private int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1,n2),n3);
    }
}
