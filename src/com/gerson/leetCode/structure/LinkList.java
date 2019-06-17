package com.gerson.leetCode.structure;

import java.util.Iterator;

public class LinkList<T> {

    private Node<T> head;
    private Node<T> tail;

    /**
     * 尾插法
     * @param _node
     */
    private void add(Node<T> _node) {
        if (head == null && tail == null) {
            head = _node;
            tail = _node;
            return;
        }
        tail.setNext(_node);
        tail = _node;
    }

    public void add(T _item) {
        Node<T> _node = new Node<>(_item);
        add(_node);
    }

    /**
     * 反转链表
     */
    public void reverse() {
        Node<T> pre = null;
        Node<T> cur = head;
        while(cur.hasNext()) {
            pre = cur;
            cur = cur.getNext();
            Node<T> temp = cur.getNext();
            pre.setNext(null);
            cur.setNext(pre);
            cur = temp;
        }
        cur.setNext(pre);
        tail = head;
        head = cur;

    }

    private static class LinkListIterator<T> implements Iterator {
        private Node<T> _head;

        public LinkListIterator(Node<T> head) {
            this._head = head;
        }

        @Override
        public boolean hasNext() {
            return _head.hasNext();
        }

        @Override
        public T next() {
            if (_head == null) {
                throw new IndexOutOfBoundsException();
            }
            return _head.getNext().getT();
        }
    }

    public Iterator<T> iterator() {
        Node<T> _head = head;
        return new LinkListIterator<T>(_head);
    }

    private static class Node<T> {
        private Node<T> next;
        private T t;

        public Node(T t) {
            this.t = t;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
