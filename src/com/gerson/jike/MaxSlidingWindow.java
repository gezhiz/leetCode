package com.gerson.jike;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 获取滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
    返回滑动窗口最大值。

 示例:

 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7]
 解释:

 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author gezz
 * @description todo
 * @date 2019/7/3.
 */
public class MaxSlidingWindow {

    /**
     * 简单实现
     */
    @Test
    public void test1() {
        int[] nums = {9,2,5,4,10,54,1,99,78,2,6,5,8,234};
        int[] result = maxSlidingWindow(nums,3);
        if (result == null) {
            return;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    /**
     * 这个算法有问题:
     * 比如：给定一个数组：{9,2,5,4,10,54,1,99,78,2,6,5,8,234}，k=3
     * 当窗口移动到5的时候，最大值应该是6，而这个算法给出的最大值是78,这种做法无法满足条件，从而想到使用双端队列来解决这个问题
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowWrong(int[] nums, int k) {
        if (nums.length < k) {
            return null;
        }
        int result[] = new int[nums.length - k + 1];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            result[i] = max;
        }
        return result;
    }

    /**
     * 可以使用大顶堆解决这个问题
     * @param nums
     * @param k
     * @return
     */
//    public int[] maxSlidingWindow(int[] nums, int k) {
//
//    }

    /**
     * 使用固定长度的双端队列解决这个问题
     * item从前面进，后面出，
     * 0、如果队列已经满了，则右边出队列
     * 1、如果遇到更大的值，清空队列，保证最大值一直存放在队列尾部，也能保证最大值在适当的时候出队列
     * 2、如果遇到更小的值，只从左边入队
     * 3、比较当前值是否是最大，最大值一直存放在队列尾部
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return null;
        }
        Deque<Integer> arrayDeque = new ArrayDeque<>(k);
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if (arrayDeque.size() == k) {
                //todo 这段处理还有问题
//                arrayDeque.pollLast();//最后的元素出队列,移除最大的元素，并且保留剩下的最大的元素
//                int curMax = 0;
//                while(arrayDeque.size() > 0) {
//                    int curItem = arrayDeque.pollLast();
//                    curMax = curItem > curMax ? curItem : curMax;
//                }
//                arrayDeque.offerFirst(curMax);
            }

            if (arrayDeque.size() > 0 && arrayDeque.getLast() < item) {
                //比最大值还大，item入队
                //队列空间受限制时使用offer，而add方法适合无限空间的队列
                arrayDeque.clear();
            }
            arrayDeque.offerFirst(item);
            result[i] = arrayDeque.getLast();
        }
        return result;
    }



}
