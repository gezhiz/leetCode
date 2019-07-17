package com.gerson.leetcode.hard;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu-b/
 * @author gezz
 * @description todo
 * @date 2019/7/17.
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length % 2 == 0) {
            return (nums[nums.length/2 - 1] + nums[nums.length/2]) / 2d;
        } else {
            return nums[nums.length/2];
        }
    }

    /**
     * 借助第三个数组来解答
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        } else if (nums1.length == 0) {
            return findMedianSortedArrays(nums2);
        } else if (nums2.length == 0){
            return findMedianSortedArrays(nums1);
        }
        int[] nums3 = new int[nums1.length + nums2.length];
        int m = 0;
        int n = 0;
        for (int i = 0; i < nums3.length; i++) {
            if (m >= nums1.length) {
                nums3[i] = nums2[n++];
            } else if (n >= nums2.length) {
                nums3[i] = nums1[m++];
            } else if (nums1[m] >= nums2[n]) {
                nums3[i] = nums2[n++];
            } else {
                nums3[i] = nums1[m++];
            }
        }
        return findMedianSortedArrays(nums3);

    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            // 保证 m <= n
            return findMedianSortedArrays(nums2,nums1);
        }
        int iMin = 0, iMax = m;
        int halfLen = (n + m + 1)/2;
        int maxLeft = 0, minRight = 0;
        while (iMin <= iMax) {
            int i = (iMax + iMin)/2;
            int j = halfLen - i;
            if (i < iMax && nums2[j-1] > nums1[i]) {
                iMin = i + 1;
            }
            else if(i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i - 1;
            } else {
                if (i == 0) maxLeft = nums2[j - 1];
                else if (j == 0) maxLeft = nums1[i - 1];
                else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);

                if ((m + n)%2 == 1) return maxLeft;

                if (i == m) minRight = nums2[j];
                else if (j == n) minRight = nums1[i];
                else minRight = Math.min(nums1[i], nums2[j]);

                return (minRight + maxLeft)/2.0;
            }
        }
        return 0.0;

    }

    @Test
    public void test() {
        int[] nums1 = {1,2};
        int[] nums2 = {-1, 3};
        double result = findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }

}
