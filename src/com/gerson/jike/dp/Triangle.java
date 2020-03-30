package com.gerson.jike.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 120题
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

 例如，给定三角形：

 [
    [2],
   [3,4],
  [6,5,7],
 [4,1,8,3]
 ]
 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

 说明：

 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/triangle
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * @author gezz
 * @description
 * @date 2020/3/30.
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
             for (int j = 0; j < triangle.get(i).size() ; j++) {
                 //下一行记录的最小值
                 List<Integer> list = triangle.get(i + 1);
                 //下一层的响铃路径的最小值，加上当前路径的值
                 triangle.get(i).set(j,Math.min(list.get(j),list.get(j + 1)) + triangle.get(i).get(j));
             }
        }
        return triangle.get(0).get(0);
    }

    @Test
    public void test() {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(list);

        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        triangle.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        triangle.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        triangle.add(list3);

        System.out.println(minimumTotal(triangle));
    }
}
