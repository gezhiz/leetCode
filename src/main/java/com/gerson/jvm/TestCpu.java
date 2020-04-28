package com.gerson.jvm;

/**
 * 使用top命令和jstack命令诊断cpu占用过高的问题
 * ps H -eo pid,tid,%cpu | grep [pid] 命令查看进程对应的线程占用cpu的比例
 * @author gezz
 * @description
 * @date 2020/4/9.
 */
public class TestCpu {
    /**
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("执行中");
                }
            }
        }).start();
        Thread.currentThread().join();
    }
}
