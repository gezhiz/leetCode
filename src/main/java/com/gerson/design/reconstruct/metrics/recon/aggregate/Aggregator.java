package com.gerson.design.reconstruct.metrics.recon.aggregate;

import com.gerson.design.reconstruct.metrics.recon.entity.RequestInfo;
import com.gerson.design.reconstruct.metrics.recon.entity.RequestStat;

import java.util.List;
import java.util.Map;

/**
 * @author gezz
 * @description
 * @date 2020/5/6.
 */
public interface Aggregator {
    Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis);
}
