package com.gerson.juc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author gezz
 * @description
 * @date 2020/4/22.
 */
public class ForkJoinDemo {

    @Test
    public void testForkJoin() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> forkJoinTask = forkJoinPool.submit(new CountTask(0L,1000L));
        try {
            System.out.println(forkJoinTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static class CountTask extends RecursiveTask<Long> {

        private Long start;
        private Long end;

        /**
         * end - start >= THRESHOLD 则需要进行任务拆分
         */
        private final static Long THRESHOLD = 1000L;

        /**
         * 默认分成100个任务
         */
        private final static Long DEFAULT_TASK_NUM = 100L;

        public CountTask(Long start, Long end) {
            if (start == null || end == null || end < start) {
                throw new IllegalArgumentException("please make sure start and end not none. also end bigger than start !");
            }
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            Long sum = 0L;
            if (canCompute(start, end)) {
                sum += doCompute(start, end);
            } else {
                Long step = step(start, end);
                ArrayList<CountTask> tasks = new ArrayList<>();
                Long curStart = start;
                long taskNum = DEFAULT_TASK_NUM;
                for (long i = 0; i < taskNum; i++) {
                    long curEnd = curStart + step;
                    if (curStart > this.end) {
                        break;
                    }
                    if (curEnd > this.end) {
                        curEnd = this.end;
                    }

                    CountTask countTask = new CountTask(curStart, curEnd);
                    tasks.add(countTask);
                    countTask.fork();

                    //记录下一段任务
                    curStart = curEnd + 1;

                }
                for (CountTask countTask : tasks) {
                    //结果聚合
                    sum += countTask.join();
                }

            }
            return sum;
        }

        public boolean canCompute(Long start, Long end) {
            return (end - start) <= THRESHOLD;
        }

        /**
         * 计算每个任务最大计算量
         * @param start
         * @param end
         * @return
         */
        private Long step(Long start, Long end) {
            return (end - start) / DEFAULT_TASK_NUM;
        }

        private Long doCompute(Long start, Long end) {
            Long sumTemp = 0L;
            //直接计算
            for (Long i = start; i <= end; i++) {
                sumTemp += i;
            }
            return sumTemp;
        }
    }
}
