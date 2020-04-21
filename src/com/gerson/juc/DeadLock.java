package com.gerson.juc;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁检测
 * CountDownLatch
 * CyclicBarrier 循环屏障：协同多个线程，让多个线程在这个屏障前等待。然后一起执行
 * Semaphore 信号量： 控制并发数。
 *
 *
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
        CountDownLatch countDownLatch = new CountDownLatch(2);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2 + 1);
        Thread thread1 = new Thread(() -> {
            try {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                lockA.lock();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockB.lock();
            } finally {
                countDownLatch.countDown();
            }
        });
        thread1.setName("threadA");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                lockB.lock();
                try {
                    Thread.sleep(9);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockA.lock();
            } finally {
                countDownLatch.countDown();
            }

        });
        thread2.setName("threadB");
        thread2.start();

        countDownLatch.await();
    }
}
