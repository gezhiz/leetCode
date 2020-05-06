package com.gerson.design.reconstruct.metrics.recon.repoter;

import com.gerson.design.reconstruct.metrics.recon.aggregate.Aggregator;
import com.gerson.design.reconstruct.metrics.recon.storage.MetricsStorage;
import com.gerson.design.reconstruct.metrics.recon.viwer.StatViewer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author gezz
 * @description
 * @date 2020/5/6.
 */

/**
 * 这个reporter相比重构前，仅仅负责任务的调度、查询基础统计信息，交给Aggregator去统计，并把统计结果呈现给Viewer
 *
 * 同时，Aggregator的任务和Viewer的执行代码已经统一交给基类AbsScheduledReporter去执行了，可以专门针对AbsScheduledReporter进行功能性的单元测试
 *
 *
 * 最终的这个Reporter版本，仅仅是负责参数传入，和任务调度
 *
 *
 */
public class ConsoleReporter extends AbsReporter {
    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    /**
     * 多线程的代码进行单元测试不太方便，所以尽可能的把多线程任务的代码做得简介明了，把复杂的代码放到线程外
     * @param periodInSeconds
     * @param durationInSeconds
     */
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(() -> {
            long durationInMillis = durationInSeconds * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            long startTimeInMillis = endTimeInMillis - durationInMillis;
            doStatAndReport(startTimeInMillis, endTimeInMillis);
        }, 0L, periodInSeconds, TimeUnit.SECONDS);
    }

}