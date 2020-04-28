package com.gerson.jike;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author gezz
 * @description
 * @date 2020/3/27.
 */
public class Parenthesis {

    /**
     * 生成括号序列
     * @param result
     * @param leftCount
     * @param rightCount
     * @param cur
     * @param n 生成n对括号
     */
    public void gen(List<String> result, Integer leftCount, Integer rightCount, String cur, Integer n) {
        if (leftCount < n) {
            //左括号没用完，可以用
            gen(result, leftCount + 1, rightCount, cur + "(", n);
        }
        if (rightCount < leftCount && rightCount < n) {
            //右括号比左括号小，并且比n小，可以用右括号
            gen(result, leftCount, rightCount + 1, cur + ")", n);
        }
        if (Objects.equals(leftCount, n)
                && Objects.equals(rightCount, n)) {
            result.add(cur);
            return;
        }
    }

    @Test
    public void test() {
        List<String> result = new ArrayList<>();
        gen(result, 0, 0, "", 4);
        for (String string : result) {
            System.out.println(string);
        }
    }
}
