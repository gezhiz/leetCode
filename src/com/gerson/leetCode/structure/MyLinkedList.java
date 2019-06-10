package com.gerson.leetCode.structure;

import java.util.Iterator;

/**
 * Created by gezz on 2019/6/6.
 */
public class MyLinkedList<T> {

    /**
     * 头指针，引用类型，用来标记链表的头部
     */
    private Node head;
    /**
     * 尾指针，引用类型，用来标记链表的尾部
     */
    private Node tail;
    /**
     * 链表的实际长度
     */
    private int size;

    public MyLinkedList() {
    }

    /**
     * 尾插发
     * @param node
     */
    private void add(Node node) {
        size++;
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.setNext(node);
        tail = node;

    }

    /**
     * 尾插发插入插入一个元素
     * @param t
     */
    public void add(T t) {
        add(new Node(t));
    }

    /**
     * 反转链表
     */
    public void reverse() {
        //初始化
        Node pre = head;
        Node cur = head.getNext();
        Node temp;
        tail = head;
        //开始循环
        while(cur != null) {
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.setNext(null);
        head = pre;
    }

    /**
     * 迭代器
     * @param <T>
     */
    private class MyIterator<T> implements Iterator {

        private Node<T> _head = head;
        @Override
        public boolean hasNext() {
            return _head != null;
        }

        @Override
        public T next() {
            T _item = _head.getItem();
            _head = _head.getNext();
            return _item;
        }

        @Override
        public void remove() {
            throw new RuntimeException("不支持删除");
        }
    }

    /**
     * 新建一个迭代器
     * @return
     */
    public Iterator<T> getIterator() {
        return new MyIterator();
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 单个节点
     * @param <T>
     */
    private static class Node<T> {
        private Node<T> next;
        private T item;

        public Node(T item) {
            this.item = item;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }

    public Node<T> getHead() {
        Node<T> _head = head;
        return _head;
    }
}
