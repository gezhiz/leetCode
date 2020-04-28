package com.gerson.leetcode.easy;

import org.junit.Test;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author gezz
 * @description
 * @date 2020/4/1.
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int len = nums.length;
        while (j < len) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    public int removeDuplicates1(int[] nums) {
        int ans = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[ans] != nums[j]) {
                nums[++ans] = nums[j];
            }
        }
        return ans + 1;
    }

    @Test
    public void test() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = removeDuplicates1(nums);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
