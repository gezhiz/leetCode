package com.gerson.jike;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author gezz
 * @description todo
 *
   给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

    示例 1:

    输入: s = "anagram", t = "nagaram"
    输出: true
    示例 2:

    输入: s = "rat", t = "car"
    输出: false
    说明:
    你可以假设字符串只包含小写字母。

 * @date 2019/7/4.
 */
public class Anagram {

    @Test
    public void test() {
//        System.out.println(isAnagram("abcdefg","becfdag"));
//        System.out.println(isAnagram("a","v"));
        System.out.println(isAnagram1("a","v"));
        System.out.println(isAnagram1("abcdefg","becfdag"));
    }

    /**
     * 使用hashMap来解决这个问题
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || s == "" || t == null || t == "") {
            return false;
        }
        byte[] sArray = s.getBytes();
        byte[] tArray = t.getBytes();
        if (sArray.length != tArray.length) {
            return false;
        }
        Map<Byte,Integer> sMap = new HashMap<>();
        Map<Byte,Integer> tMap = new HashMap<>();
        for (int i = 0; i < sArray.length; i++) {
            if (sMap.containsKey(sArray[i])) {
                sMap.put(sArray[i],sMap.get(sArray[i]) + 1);
            } else {
                sMap.put(sArray[i],1);
            }
            if (tMap.containsKey(tArray[i])) {
                tMap.put(tArray[i],tMap.get(tArray[i]) + 1);
            } else {
                tMap.put(tArray[i],1);
            }
        }
        for (Map.Entry<Byte,Integer> entry : tMap.entrySet()) {
            if (!Objects.equals(entry.getValue(),sMap.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用一个包含26个字母的数组解决此问题
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if (s == null || s == "" || t == null || t == "") {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] has = new int[26];
        for (int i = 0; i < s.length(); i++) {
            has[s.charAt(i) - 'a']++;
            has[t.charAt(i) - 'a']--;
        }
        for (int i : has) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
