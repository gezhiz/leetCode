package com.gerson.leetCode.structure;

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

    private static class Node<T> {
        private Node<T> next;
        private T t;

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
    }
}
