package com.gerson.interview;

import org.junit.Test;

/**
 * @author gezz
 * @description
 * @date 2020/6/17.
 */
public class MyLinkedList<T extends Comparable> {

    private Node<T> head;

    private class Node<T> {
        public Node<T> next;
        public T value;
    }

    /**
     * 插入，保证升序
     * @param t
     */
    public boolean orderedInsert(T t) {
        if (t == null) {
            return false;
        }
        Node<T> node = new Node<T>();
        node.value = t;
        if (head == null) {
            head = node;
            return true;
        }
        Node<T> cur = head;
        while (cur.next != null && t.compareTo(cur.value) > 0) {
            cur = cur.next;
        }
        if (cur == head) {
            head = node;
            node.next = cur;
        } else {
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }

    /**
     * 删除所有的value
     * @param value
     * @return
     */
    public boolean del(T value) {
        if (value == null) {
            return false;
        }
        Node<T> cur = head;
        if (cur.value.equals(value)) {
            //头结点开始就是value
            while (cur.next != null && value.equals(cur.next.value)) {
                cur = cur.next;
            }
            head = cur.next;
            //help gc
            cur.next = null;
            return true;
        }

        //先找到第一个value
        while(cur != null & cur.value != null
                && cur.next != null && cur.next.value != value) {
            cur = cur.next;
        }

        if (cur == null || cur.next == null) {
            return false;
        }
        cur.next = cur.next.next;
        return true;
    }

    public Node<T> reverse(Node<T> head) {
        if (head == null) return head;
        Node<T> pre = head;
        Node<T> cur = pre.next;
        Node<T> tmp = null;
        //利用pre构造一个新链表
        head.next = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    @Test
    public void testReverse() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
        linkedList.orderedInsert(3);
        linkedList.orderedInsert(1);
        linkedList.orderedInsert(6);
        linkedList.orderedInsert(10);
        linkedList.orderedInsert(1);
        linkedList.head = linkedList.reverse(linkedList.head);
        System.out.println(linkedList.head);
    }

    @Test
    public void test() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
        linkedList.orderedInsert(3);
        linkedList.orderedInsert(1);
        linkedList.orderedInsert(6);
        linkedList.orderedInsert(10);
        linkedList.orderedInsert(1);
        System.out.println(linkedList.head.value);
        linkedList.del(10);
        System.out.println(linkedList.head);
    }
}
