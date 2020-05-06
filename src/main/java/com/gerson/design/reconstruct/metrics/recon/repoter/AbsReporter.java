package com.gerson.design.reconstruct.metrics.recon.repoter;

import com.gerson.design.reconstruct.metrics.recon.aggregate.Aggregator;
import com.gerson.design.reconstruct.metrics.recon.entity.RequestInfo;
import com.gerson.design.reconstruct.metrics.recon.entity.RequestStat;
import com.gerson.design.reconstruct.metrics.recon.storage.MetricsStorage;
import com.gerson.design.reconstruct.metrics.recon.viwer.StatViewer;

import java.util.List;
import java.util.Map;

/**
 *
 * 为了实现代码复用而创建的基类
 * @author gezz
 * @description
 * @date 2020/5/6.
 */
public abstract class AbsReporter {
    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;

    public AbsReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    /**
     * 真正执行聚合统计和view显示输出的方法
     *
     * @param startTimeInMillis
     * @param endTimeInMillis
     */
    protected void doStatAndReport(Long startTimeInMillis, Long endTimeInMillis) {
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String,List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
        viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
    }
}
