package com.gerson.juc.lockfree;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 让基本类型的修改享受cas操作
 * @author gezz
 * @description
 * @date 2020/5/3.
 */
public class AtomicIntegerFieldUpdaterDemo {

    public static class Candidate {
        private Integer id;
        private volatile int score;
        private final static AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

        public Integer getId() {
            return id;
        }

        public Integer getScore() {
            return scoreUpdater.get(this);
        }

        public void vote() {
            scoreUpdater.incrementAndGet(this);
//            score = score + 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Candidate candidate = new Candidate();
        int count = 1000;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                for (int j = 0 ; j < 100; j++) {
                    candidate.vote();
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(candidate.getScore());
    }

}
