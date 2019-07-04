package com.gerson.jike;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

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
        int[] nums = {9,2,9,4,10,54,1,99,78,2,4,5,2,33,45,2,4,5,6,5,8,234};
        int[] result = maxSlidingWindow(nums,5);
        if (result == null) {
            return;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    /**
     * 最大值存放在队列最左边
     * 每次从右边入队时，如果右边有更小的元素，则让其弹出.如果队列被清空，当前item就是最大值，记录当前最大值的索引，根据k和i的值来判定最大值是否已经划出了窗口
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums == null) {
            return new int[0];
        }
        Deque<Integer> arrayDeque = new ArrayDeque<>(k);
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            //判断最大值是否在窗口内部
            if (arrayDeque.size() > 0 && arrayDeque.getFirst() <= i - k) {
                //无效
                arrayDeque.pollFirst();
            }
            while (arrayDeque.size() > 0 && item >= nums[arrayDeque.getLast()]) {
                arrayDeque.pollLast();
            }
            arrayDeque.addLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[arrayDeque.getFirst()];
            }
        }
        return result;
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
            return new int[0];
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
     * 最大值存放在队列最左边
     * 每次从右边入队时，如果右边有更小的元素，则让其弹出.如果队列被清空，当前item就是最大值，记录当前最大值的索引，根据k和i的值来判定最大值是否已经划出了窗口
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindoWrong2(int[] nums, int k) {
        if (k == 0 || nums == null) {
            return new int[0];
        }
        Deque<Integer> arrayDeque = new ArrayDeque<>(k);
        int[] result = new int[nums.length - k + 1];
        //记录当前最大值在数列中的索引
        int curMaxIndex = 0;
        //记录第二大的数
        int nextMaxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            //判断最大值是否在窗口内部
            if (arrayDeque.size() > 0 && curMaxIndex <= i - k) {
                //最大值被移除，新的最大值变成了第二个数
                arrayDeque.pollFirst();
                //todo 更新最大值的索引
                if (nextMaxIndex != 0) {
                    curMaxIndex = nextMaxIndex;
                }
            }
            while (arrayDeque.size() > 0 && item >= arrayDeque.getLast()) {
                arrayDeque.pollLast();
            }
            if (arrayDeque.size() == 0) {
                //队列被清空，item为当前窗口的最大值，更新curMaxIndex
                curMaxIndex = i;
                nextMaxIndex = 0;
            } else if (arrayDeque.size() == 1) {
                //仅仅剩下最大的数
                nextMaxIndex = i;
            }
            arrayDeque.addLast(item);
            if (i >= k - 1) {
                result[i - k + 1] = arrayDeque.getFirst();
            }
        }
        return result;
    }

    /**
     * 其他人的算法
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return nums;
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }



}
