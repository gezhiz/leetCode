package com.gerson.wangzeng.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gezz gezhizheng@xiaomi.com
 * @description
 * @date 2020/11/18.
 */
public class LRUCache<K extends Comparable<K>, V> {

    private LinkNode<K, V> head;

    private Map<K, LinkNode<K,V>> indexMap = new HashMap<K, LinkNode<K,V>>();

    private class LinkNode<K extends Comparable<K>, V> {
        public LinkNode pre;
        public LinkNode next;
        public K key;
        public V value;

        public LinkNode(LinkNode pre, LinkNode next, K key, V value) {
            this.pre = pre;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }

    public LinkNode<K,V> get(K key) {
        LinkNode linkNode = remove(key);
        if (linkNode == null) {
            return null;
        }
        //注意头结点：头结点就是要找的节点
        if (linkNode == head) {
            return linkNode;
        }
        //头插法
        insertFirst(key, linkNode);
        return linkNode;
    }
    public void put(K key, V value) {
        LinkNode<K,V> linkNode = remove(key);
        if (linkNode == null) {
            linkNode = new LinkNode<K,V>(null, head == null ? null : head.next, key, value);
        }

        //头插法
        insertFirst(key, linkNode);
    }

    /**
     * 头插法
     * @param key
     * @param linkNode
     */
    private void insertFirst(K key, LinkNode<K, V> linkNode) {
        linkNode.next = head;
        if (head != null) {
            head.pre = linkNode;
        }
        head = linkNode;
        indexMap.put(key, linkNode);
    }

    public LinkNode<K,V> remove(K key) {
        if (key == null) {
            return null;
        }
        LinkNode linkNode = indexMap.remove(key);
        if (linkNode == null) {
            //不存在
            return null;
        }

        //注意头结点，删除头结点是一个特殊的操作
        if (linkNode == head) {
            head = linkNode.next;
            return linkNode;
        }
        if (linkNode.pre != null) {
            linkNode.pre.next = linkNode.next;
        }
        if (linkNode.next != null) {
            linkNode.next.pre = linkNode.pre;
            linkNode.next = null;
        }

        return linkNode;
    }

    public static void main(String[] args) {
        LRUCache<String,Integer> lruCache = new LRUCache<>();
        lruCache.put("1", 1);
        lruCache.put("2", 2);
        lruCache.put("3", 2);
        lruCache.put("4", 2);
        lruCache.put("4", 2);
        lruCache.put("1", 2);
        lruCache.get("3");
        System.out.println(lruCache.toString1());
    }

    public String toString1() {
        StringBuilder sb = new StringBuilder("LRUCache{");
        LinkNode tmp = head;
        while (tmp != null) {
            sb.append("(").append(tmp.key).append(",").append(tmp.value).append(")");
            tmp = tmp.next;
        }
        return sb.append("}").toString();
    }


}
