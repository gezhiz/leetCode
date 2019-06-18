package com.gerson.leetcode.easy;

import com.gerson.leetcode.structure.MyStack;
import org.junit.Test;

public class StackTest {

    @Test
    public void testStack() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        System.out.println("堆栈空间的长度：" +stack.getSize());

        Integer item;
        while((item = stack.pop()) != null) {
            System.out.println(item);
        }
    }

}
