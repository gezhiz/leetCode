package com.gerson.design.reconstruct.metrics.recon.repoter;

import com.gerson.design.reconstruct.metrics.recon.aggregate.Aggregator;
import com.gerson.design.reconstruct.metrics.recon.entity.RequestInfo;
import com.gerson.design.reconstruct.metrics.recon.entity.RequestStat;
import com.gerson.design.reconstruct.metrics.recon.storage.MetricsStorage;
import com.gerson.design.reconstruct.metrics.recon.viwer.StatViewer;

import java.util.ArrayList;
import java.util.HashMap;
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

    private static final long MAX_STAT_DURATION_IN_MILLIS = 10 * 60 * 1000; // 10minutes

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
        //防止数据量太大导致requestInfos内存溢出，采用分布统计的方式进行
//        Map<String,List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
//
//        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
        Map<String, RequestStat> stats = doStat(startTimeInMillis, endTimeInMillis);
        viewer.output(stats, startTimeInMillis, endTimeInMillis);
    }

    private Map<String, RequestStat> doStat(long startTimeInMillis, long endTimeInMillis) {
        Map<String, List<RequestStat>> segmentStats = new HashMap<>();
        long segmentStartTimeMillis = startTimeInMillis;
        while (segmentStartTimeMillis < endTimeInMillis) {
            long segmentEndTimeMillis = segmentStartTimeMillis + MAX_STAT_DURATION_IN_MILLIS;
            if (segmentEndTimeMillis > endTimeInMillis) {
                segmentEndTimeMillis = endTimeInMillis;
            }
            Map<String, List<RequestInfo>> requestInfos =
                    metricsStorage.getRequestInfos(segmentStartTimeMillis, segmentEndTimeMillis);
            if (requestInfos == null || requestInfos.isEmpty()) {
                continue;
            }
            Map<String, RequestStat> segmentStat = aggregator.aggregate(
                    requestInfos, segmentEndTimeMillis - segmentStartTimeMillis);
            addStat(segmentStats, segmentStat);
            segmentStartTimeMillis += MAX_STAT_DURATION_IN_MILLIS;
        }

        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, RequestStat> aggregatedStats = aggregateStats(segmentStats, durationInMillis);
        return aggregatedStats;
    }
    private void addStat(Map<String, List<RequestStat>> segmentStats,
                         Map<String, RequestStat> segmentStat) {
        for (Map.Entry<String, RequestStat> entry : segmentStat.entrySet()) {
            String apiName = entry.getKey();
            RequestStat stat = entry.getValue();
            List<RequestStat> statList = segmentStats.putIfAbsent(apiName, new ArrayList<>());
            statList.add(stat);
        }
    }

    private Map<String, RequestStat> aggregateStats(Map<String, List<RequestStat>> segmentStats,
                                                    long durationInMillis) {
        Map<String, RequestStat> aggregatedStats = new HashMap<>();
        for (Map.Entry<String, List<RequestStat>> entry : segmentStats.entrySet()) {
            String apiName = entry.getKey();
            List<RequestStat> apiStats = entry.getValue();
            double maxRespTime = Double.MIN_VALUE;
            double minRespTime = Double.MAX_VALUE;
            long count = 0;
            double sumRespTime = 0;
            for (RequestStat stat : apiStats) {
                if (stat.getMaxResponseTime() > maxRespTime) maxRespTime = stat.getMaxResponseTime();
                if (stat.getMinResponseTime() < minRespTime) minRespTime = stat.getMinResponseTime();
                count += stat.getCount();
                sumRespTime += (stat.getCount() * stat.getAvgResponseTime());
            }
            RequestStat aggregatedStat = new RequestStat();
            aggregatedStat.setMaxResponseTime(maxRespTime);
            aggregatedStat.setMinResponseTime(minRespTime);
            aggregatedStat.setAvgResponseTime(sumRespTime / count);
            aggregatedStat.setCount(count);
            aggregatedStat.setTps(count / durationInMillis * 1000);
            aggregatedStats.put(apiName, aggregatedStat);
        }
        return aggregatedStats;
    }
}
