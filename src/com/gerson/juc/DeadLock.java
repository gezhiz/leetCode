package com.gerson.juc;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gezz
 * @description
 * @date 2020/4/11.
 */
public class DeadLock {
    private static Lock lockA = new ReentrantLock();
    private static Lock lockB = new ReentrantLock();

    /**
     * 解决AB死锁的问题
     * @param type
     * @return
     */
    private static synchronized Lock lock(String type) {
        if ("A".equals(type)) {
            lockA.lock();
            return lockA;
        }
        if ("B".equals(type)) {
            lockB.lock();
            return lockB;
        }
        throw new IllegalArgumentException();
    }

    /**
     * 死锁案例
     * 死锁的条件：AB 两个锁的获取顺序相反
     * 解决方法：
     *  1、AB两个锁的获取顺序要相同
     *  2、把获取A锁和B锁的方法设置成原子操作
     *
     *
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            lockA.lock();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockB.lock();
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            lockB.lock();
            try {
                Thread.sleep(9);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockA.lock();
        });
        thread2.start();
    }
}
