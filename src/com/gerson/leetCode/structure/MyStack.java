package com.gerson.leetCode.structure;

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
    private int index;
    /**
     * 站内元素数量
     */
    private int size;
    /**
     * 栈容量
     */
    private int capacity;

    public MyStack() {
        this.capacity = DEFAULT_LENGTH;
        this.size = 0;
        this.index = 0;
        items = new Object[capacity];
    }

    public E pop() {

        return (E) items[index];
    }

    public E push(E e) {

    }

    public static Integer getDefaultLength() {
        return DEFAULT_LENGTH;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
