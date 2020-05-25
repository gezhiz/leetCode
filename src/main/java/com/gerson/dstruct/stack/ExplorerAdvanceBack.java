package com.gerson.dstruct.stack;

import com.gerson.leetcode.structure.MyStack;
import org.junit.Test;

/**
 * 模拟浏览器的前进后退
 * @author gezz
 * @description
 * @date 2020/5/25.
 */
public class ExplorerAdvanceBack {
    private MyStack<String> stack1 = new MyStack<>();
    private MyStack<String> stack2 = new MyStack<>();

    @Test
    public void test() {
        ExplorerAdvanceBack explorer = new ExplorerAdvanceBack();
        explorer.browse("a");
        explorer.browse("b");
        explorer.browse("c");
        explorer.browse("d");
        System.out.println(explorer.back());
        System.out.println(explorer.advance());
        System.out.println(explorer.back());
        System.out.println(explorer.back());
        System.out.println(explorer.advance());
        System.out.println(explorer.advance());
    }

    /**
     * 浏览网页
     * @param url
     */
    public void browse(String url) {
        stack1.push(url);
    }

    /**
     * 回退
     * @return
     */
    public String back() {
        String cur = stack1.pop();
        stack2.push(cur);
        return stack1.get();
    }

    /**
     * 前进
     * @return
     */
    public String advance() {
        String result = stack2.pop();
        stack1.push(result);
        return result;
    }

}
