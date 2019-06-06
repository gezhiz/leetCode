package com.gerson.leetCode.structure;

import java.util.Iterator;

/**
 * Created by gezz on 2019/6/6.
 */
public class MyLinkedList<T> {

    //头结点
    private Node head;
    //尾节点
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = new Node(null);
        this.tail = new Node(null);
    }

    /**
     * 尾插发
     * @param node
     */
    public void add(Node node) {
        if (head.getNext() == null) {
            head.setNext(node);
            tail.setNext(node);
            return;
        }
        tail.getNext().setNext(node);
        tail.setNext(node);

    }

    public void add(T t) {
        add(new Node(t));
    }

    public void reverse() {
        //初始化
        Node newHead = null;
        Node cur = head.getNext();
        //开始循环
        while(cur != null) {
            //使用头插法把cur插入到newHead
            newHead = cur;

            cur = cur.getNext();
        }
        head = newHead;
    }
    private class MyIterator<T> implements Iterator {

        private Node<T> index = head;
        @Override
        public boolean hasNext() {
            return index.getNext() != null;
        }

        @Override
        public T next() {
            index = index.getNext();
            return index.getItem();
        }

        @Override
        public void remove() {
            throw new RuntimeException("不支持删除");
        }
    }

    public Iterator<T> getIterator() {
        return new MyIterator();
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

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
