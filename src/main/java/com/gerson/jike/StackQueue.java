package com.gerson.jike;

import com.gerson.leetcode.structure.MyStack;
import org.junit.Test;


/**
 * @author gezz
 * @description 使用栈实现队列
 * @date 2019/6/19.
 */
public class StackQueue<E> {
    private MyStack<E> inputStack;
    private MyStack<E> outputStack;
    private int size;

    public StackQueue() {
        this.inputStack = new MyStack<>();
        this.outputStack = new MyStack<>();
    }

    public void add(E item) {
        inputStack.push(item);
        size++;
    }

    public E get() {
        size--;
        if (outputStack.getSize() > 0) {
            return outputStack.pop();
        }
        while (inputStack.getSize() > 0) {
            outputStack.push(inputStack.pop());
        }
        return outputStack.pop();
    }
    public int size() {
        return size;
    }

    @Test
    public void testAddGet() {
        StackQueue<Integer> stackQueue = new StackQueue<>();
        stackQueue.add(1);
        stackQueue.add(2);
        stackQueue.add(3);
        stackQueue.add(4);
        stackQueue.add(5);
        stackQueue.add(6);
        stackQueue.add(7);
        while (stackQueue.size() > 0) {
            System.out.println(stackQueue.get());
        }
    }
}
