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

    /**
     * 三重循环，暴力求解
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outList = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            // 各循环起始点不需要判断重复
            if ((i > 0 && nums[i] == nums[i - 1])) {
                // 不用i++ 的原因：避免最后的k还要增加边界判断，进入下一个循环则会自动边界判断“i < nums.length”
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if ((j > i + 1 && nums[j] == nums[j - 1])) {
                    // 当有很多for和if的时候，条件取反后用continue，以此取代if的{}缩进，使代码可读性增加
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
//                    if ((k > j + 1 && nums[k] == nums[k - 1])) {
//                        continue;
//                    }
                    if ((nums[i] + nums[j] + nums[k] == 0)) {
                        List<Integer> inList = new ArrayList<Integer>();
                        inList.add(nums[i]);
                        inList.add(nums[j]);
                        inList.add(nums[k]);
                        outList.add(inList);
                        break;
                    }
                }
            }
        }
        return outList;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums,0);
    }
    private List<List<Integer>> threeSum(int[] nums, int k) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if ((i >= 1 && nums[i] == nums[i - 1])) {
                //去除重复情况
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(k - (nums[i] + nums[j]))) {
                    if (map.get(k - (nums[i] + nums[j])) <= j) {
                        continue;//去重
                    }
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

    /**
     * 双指针
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums); // 排序
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 针对排序后的结果，如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (nums == null || nums.length < 3) {
            return result;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i -1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while(right > left) {
                int sum = nums[i] + nums[right] + nums[left];
                if (sum == k) {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < k) {
                    left++;
                } else if (sum > k){
                    right--;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {-4, -1, -1, 0, 1, 2, 2,-2,1,1};
//        int[] nums = {0,0,0,0};
//        List<List<Integer>> result = threeSum1(nums);
//        List<List<Integer>> result = threeSum(nums);
        List<List<Integer>> result = threeSum2(nums,0);
        for (List<Integer> items : result) {
            for (Integer item : items) {
                System.out.print(item + " ");
            }
            System.out.println("");
        }
    }

}
