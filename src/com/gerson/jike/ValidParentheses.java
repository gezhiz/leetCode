package com.gerson.jike;

import com.gerson.leetcode.structure.MyStack;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author gezz
 * @description 判断括号的有效性
 * @date 2019/6/18.
 */
public class ValidParentheses {

    public static Map<Character,Character> mapper = new HashMap<>();
    static {
        mapper.put(new Character('}'),new Character('{'));
        mapper.put(new Character(')'),new Character('('));
        mapper.put(new Character(']'),new Character('['));
    }
    public static boolean isValid(String str) {
        if (str == null) {
            return true;
        }
        MyStack<Character> stack = new MyStack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (mapper.containsKey(c)) {
                // popItem : { [ (
                char popItem = stack.pop();
                if (Objects.equals(mapper.get(c) , popItem)) {
                    continue;
                } else {
                    return false;
                }
            } else if (mapper.containsValue(c)) {
                stack.push(c);
            } else {
                continue;
            }
        }
        return stack.getSize() == 0;
    }

    @Test
    public void testValid() {
        System.out.println(isValid("[[[[(shs{[e}]hew)]]]]"));
    }
}
