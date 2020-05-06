package com.gerson.design.reconstruct.metrics.recon.aggregate;

import com.gerson.design.reconstruct.metrics.recon.entity.RequestInfo;
import com.gerson.design.reconstruct.metrics.recon.entity.RequestStat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板方法模式，对子类提供模板方法，子类实现自己的个性化方法
 * @author gezz
 * @description
 * @date 2020/5/6.
 */
public abstract class AbsAggregator implements Aggregator {
    /**
     * aggregate 负责循环处理传入的数据，并调用具体的聚合操作
     * @param requestInfos
     * @param durationInMillis
     * @return
     */
    @Override
    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
            requestStats.put(apiName, requestStat);
        }
        return requestStats;
    }

    protected abstract RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis);

}
