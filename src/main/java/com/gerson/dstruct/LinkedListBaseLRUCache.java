package com.gerson.dstruct;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 基于LRU替换算法的缓存实现思路：
 * 1、向缓存中加入一个元素时，如果缓存已经满了，则移除最后一个元素；如果缓存未满，则直接添加到首部。
 * 2、当方位链表中的元素时，把被访问的node删除，然后把这个节点放入链表首部
 * 3、优化方案：使用双向链表 + hash表的结构，能够提高查询效率和删除效率
 *      hash表结构，保存key和node节点的引用，在已知node节点的情况，进行删除节点操作更加方便
 * @author gezz
 * @description
 * @date 2020/5/20.
 */
public class LinkedListBaseLRUCache<K,E> {
    private Integer maxSize;
    private LinkedList<Element<K,E>> cache;

    public LinkedListBaseLRUCache(Integer maxSize) {
        if (maxSize == null) {
            throw new IllegalArgumentException("maxSize can't be none!");
        }
        cache = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public boolean add(K key, E e) {
        if (key == null) {
            throw new IllegalArgumentException("key can't be none!");
        }
        if (e == null) {
            throw new IllegalArgumentException("element can't be none!");
        }
        while(cache.size() >= maxSize) {
            cache.removeLast();
        }
        cache.addFirst(new Element<>(key, e));
        return true;
    }

    public E get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key can't be none!");
        }
        Iterator<Element<K,E>> iterator = cache.iterator();
        Element<K,E> element = null;
        while(iterator.hasNext() && (element = iterator.next()) != null) {
            if (key.equals(element.getK())) {
                iterator.remove();
                break;
            }
        }
        cache.addFirst(element);
        return element.getE();
    }

    private static class Element<K,E> {
        private K k;
        private E e;

        public Element(K k, E e) {
            this.k = k;
            this.e = e;
        }

        public K getK() {
            return k;
        }

        public void setK(K k) {
            this.k = k;
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }
    }

    public static void main(String[] args) {
        LinkedListBaseLRUCache<String,Integer> cache = new LinkedListBaseLRUCache<String,Integer>(3);
        cache.add("gezz", 100);
        cache.add("liudan", 111);
        cache.add("12", 222);
        cache.add("45", 333);

        Integer value = cache.get("45");
        System.out.println(value);

        System.out.println(cache);
    }
}
