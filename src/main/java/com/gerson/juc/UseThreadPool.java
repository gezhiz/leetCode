package com.gerson.juc;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author gezz
 * @description
 * @date 2020/4/21.
 */
public class UseThreadPool {

    @Test
    public void testFixRate() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        int period = 2;
        //周期性的调度任务
        //如果前面的任务未完成，不会调用后续任务。
        //任务的调度间隔为period
        //如果任务本身发生异常，后续的任务则无法调度
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis()/1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, period, TimeUnit.SECONDS);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFixedDelay() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        int period = 2;
        int workTime = 1;
        //周期性的调度任务
        //如果前面的任务未完成，不会调用后续任务。
        //任务的调度间隔为 period + 上一个线程的执行时间 = period + work (单位：s)
        //如果任务本身发生异常，后续的任务则无法调度
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(workTime * 1000);
                    System.out.println(System.currentTimeMillis()/1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, period, TimeUnit.SECONDS);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
