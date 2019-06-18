package com.gerson.leetcode.structure;


/**
 * @description 数据结构：栈，基于数组的实现
 * @author gezz
 * @date 2019/6/17.
 */
public class MyStack<E> {

    /**
     * 默认栈空间大小
     */
    private final static Integer DEFAULT_LENGTH = 10;
    /**
     * 栈内存放的元素
     */
    private Object[] items;
    /**
     * 记录栈顶元素位置
     */
    private int top;
    /**
     * 栈容量
     */
    private int capacity;

    public MyStack() {
        this.capacity = DEFAULT_LENGTH;
        this.top = -1;
        items = new Object[capacity];
    }

    public E pop() {
        if (getSize() == 0) {
            return null;
        }
        E item = (E) items[top];
        items[top--] = null;
        return item;
    }

    public void push(E e) {
        if (getSize() == capacity) {
            expand();
        }
        items[++top] = e;
    }

    private void expand() {
        Object[] newItems = new Object[capacity + DEFAULT_LENGTH];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
    }

    public static Integer getDefaultLength() {
        return DEFAULT_LENGTH;
    }

    public int getSize() {
        return  top + 1;
    }

    public int getCapacity() {
        return capacity;
    }
}
