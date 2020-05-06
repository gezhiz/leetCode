package com.gerson.juc;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 单机 流量控制
 *
 * @author gezz
 * @description
 * @date 2020/5/6.
 */
public class RateLimit {

    /**
     * 每秒限制流量
     */
    private final static long PERMITS_PER_SECOND = 100L;
    private static AtomicInteger passNum = new AtomicInteger(0);
    private static AtomicInteger unpassNum = new AtomicInteger(0);

    final static RateLimiter rateLimiter = RateLimiter.create(PERMITS_PER_SECOND);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                boolean pass = rateLimiter.tryAcquire(10, TimeUnit.MILLISECONDS);
                if (pass) {
                    System.out.println("通过");
                    casAdd(passNum);
                } else {
                    System.out.println("被限流");
                    casAdd(unpassNum);
                }

            }).start();
            Thread.sleep(10);
        }
        Thread.sleep(1000);

        System.out.println(passNum.get());
        System.out.println(unpassNum.get());
    }

    private static void casAdd(AtomicInteger unpassNum) {
        while (true) {
            int oldNum = unpassNum.get();
            if (unpassNum.compareAndSet(oldNum, oldNum + 1)) {
                return;
            }
        }
    }
}
