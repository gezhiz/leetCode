package com.gerson.leetCode.easy;

import org.junit.Test;

import java.util.*;

/**
 * 最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

     示例 1:
     输入: "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 * Created by gezz on 2019/3/12.
 */
public class LongestSub {

    //暴力算法
    public int getLongestSubString(String s) {
        List<Character> characters = new ArrayList<>();
        int maxLen = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int index = characters.indexOf(c);
            if (index != -1) {
                maxLen = Math.max(maxLen, characters.size());//如果存在，则计算最大
                Iterator iterator = characters.iterator();
                int i = 0;
                while (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                    if (i++ == index) {
                        break;
                    }
                }
            }
            characters.add(c);
        }
        maxLen = Math.max(maxLen,characters.size());
        return maxLen;
    }

    //借助hashmap，记录重复的数据的位置
    public int getLongestSubString2(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;//最大长度
        int cursor = 0;//记录出现相同字母的最新初始位置
        for (int i = 0; i < len; i++) {
            Character iChar = s.charAt(i);
            Integer iCharIndex = map.get(iChar);
            if (iCharIndex != null && cursor <= iCharIndex) {
                maxLen = Math.max(maxLen, i - cursor);
                cursor = map.get(iChar) + 1;
            }
            map.put(iChar,i);
        }
        maxLen = Math.max(maxLen, len - cursor);
        return maxLen;
    }

    @Test
    public void test() {
//        System.out.println(getLongestSubString("pwxshecwkew"));
        System.out.println(getLongestSubString2("abba"));
    }
}
