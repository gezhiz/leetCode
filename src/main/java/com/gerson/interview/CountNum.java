package com.gerson.interview;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程方式统计数据个数
 * @author gezz
 * @description
 * @date 2020/6/18.
 */
public class CountNum {

    public static void main(String[] args) throws InterruptedException {
        //Value元素要求使用AtomicInteger,保证对AtomicInteger的更新的原子性
        Map<Integer,AtomicInteger> result = new ConcurrentHashMap<Integer, AtomicInteger>();
        int[] array = {5,1,2,3,4,5,6,7,9,1,2,3,4,1,2,4,5,6,8,9,0,3,4,5,5,5};

        int n = 4;
        int len = array.length;
        if (len <= n) {
            n = 1;
        }
        CountDownLatch latch = new CountDownLatch(n);

        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);
        //使用偏移量，确保任务分配的合理性，每次分配n个元素
        int offset = 0;
        while (offset < len) {
            int start = offset;
            int end = start + len / n;
            offset += (end - start);
            threadPoolExecutor.submit(new CountTask(array, start, end, latch, result));
        }
        latch.await();
        System.out.println(result);
        System.exit(0);
    }

    /**
     * 写这个类之前，要考虑清楚需要哪些变量
     */
    static class CountTask implements Runnable {

        private int[] array;
        private Map<Integer,AtomicInteger> result;
        private int start;
        private int end;
        private CountDownLatch countDownLatch;

        public CountTask(int[] array, int start, int end, CountDownLatch countDownLatch, Map<Integer,AtomicInteger> result) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.countDownLatch = countDownLatch;
            this.result = result;
        }

        @Override
        public void run() {
            try {
                for (int i = start; i < end; i++) {
                    Integer item = array[i];
                    result.putIfAbsent(item, new AtomicInteger(0));
                    AtomicInteger iCount = result.get(item);
                    while (!iCount.compareAndSet(iCount.get(), iCount.get() + 1)){
                    }
                }

            } finally {
                countDownLatch.countDown();
            }
        }
    }


}
