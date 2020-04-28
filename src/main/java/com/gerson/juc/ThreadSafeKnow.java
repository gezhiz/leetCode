package com.gerson.juc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 关于线程安全的理解
 * 如下是一个计数工具，针对计数工具，搞清楚哪些操作需要保证原子性，定义线程安全才有意义
 *
 * @author gezz
 * @description
 * @date 2020/4/11.
 */
public class ThreadSafeKnow {

    /**
     * 基于hashmap的实现
     */
    static class HashMapImpl {
        /**
         * HashMap 支持空值
         */
        public Map<String,Integer> map = new HashMap<>();

        public synchronized void add(String key) {
            Integer old = map.get(key);
            if (old == null) {
                map.put(key,1);
                return;
            }
            map.put(key,old + 1);

        }
    }

    /**
     * 基于ConcurrentHashMap的实现
     */
    static class ConcurrentHashMapImpl {
        public Map<String,Integer> map = new ConcurrentHashMap<>();

        public void add(String key) {
            Integer old = map.get(key);
            if (old == null) {
                map.put(key,1);
                return;
            }
            map.put(key,old + 1);

        }
    }

    /**
     * 测试结果:
     原因：ConcurrentHashMap只保证了其内部每一个操作是原子的，而本计数器的原子性要求是，map.get(key) 和map.put() 均要保证原子性
     0:1000
     1:1000
     2:1000
     3:1000
     4:1000
     5:1000
     6:1000
     7:1000
     8:1000
     9:1000
     concurrentHashMap:==============
     0:996      //出现计数不准确的情况
     1:1000
     2:1000
     3:1000
     4:1000
     5:1000
     6:1000
     7:1000
     8:1000
     9:1000

     * @throws InterruptedException
     */

    @Test
    public void test() throws InterruptedException {
        HashMapImpl hashMapImpl = new HashMapImpl();
        ConcurrentHashMapImpl concurrentHashMapImpl = new ConcurrentHashMapImpl();

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    concurrentHashMapImpl.add("" + j);
                    hashMapImpl.add("" + j);
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("hashMap:==============");
        for (Map.Entry entry : hashMapImpl.map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("concurrentHashMap:==============");
        for (Map.Entry entry : concurrentHashMapImpl.map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

}
