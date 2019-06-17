package com.gerson.leetCode.structure;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
     * 1->2->3->4->5   =>  5->4->3->2->1
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
     * 两两结点反转
     * 1->2->3->4     =>   2->1->4->3
     * 1->2->3->4->5  =>   2->1->4->3->5
     */
    public void doubleReverse() {
        if (head == null) {
            return;
        }
        Node<T> pre_pre = null;
        Node<T> pre = head;
        Node<T> cur = head.getNext();
        while(cur != null) {
            if (pre_pre == null) {
                //第一次置换
                head = cur;
            } else{
                pre_pre.setNext(cur);
            }
            pre_pre = cur;
            pre.setNext(cur.getNext());
            cur.setNext(pre);
            //三个指针均向后偏移
            pre = pre.getNext() == null ? pre : pre.getNext();
            cur = pre.getNext();
            pre_pre = pre_pre.getNext();
        }
        tail = pre;
    }

    /**
     * 制造链表环
     * 制造end位置指向start位置的循环链表
     */
    public void makeLoop(int start) {
        if (start > size) {
            tail.setNext(head);
        }
        int i = 0;
        Node<T> startNode = head;
        while(start > i++) {
            startNode = startNode.getNext();
            if (start <= i) {
                break;
            }
        }
        tail.setNext(startNode);

    }


    /**
     * set集合记录法：
     * 判断链表是否有循环
     */
    public boolean hasLoop1() {
        Node<T> cur = head;
        Set<Node<T>> sets = new HashSet<>();
        while(cur != null) {
            if (sets.contains(cur)) {
                return true;
            } else {
                sets.add(cur);
            }
            cur = cur.getNext();
        }
        return false;
    }

    /**
     * 快慢指针的方法：
     * 判断链表是否有循环
     */
    public boolean hasLoop2() {
        Node<T> slow = head;
        Node<T> fast = head;
        while(true) {
            slow = slow.getNext();
            fast = fast.getNext();
            if (fast == null) {
                return false;
            } else {
                fast = fast.getNext();
            }

            if (fast == slow) {
                return true;
            }
        }
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
