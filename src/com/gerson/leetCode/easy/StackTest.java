package com.gerson.leetCode.easy;

import com.gerson.leetCode.structure.MyStack;
import org.junit.Test;

public class StackTest {

    @Test
    public void testPush() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        Integer item = null;
        while((item = stack.pop()) != null) {
            System.out.println(item);
        }
    }

    public void testPop() {

    }

}
