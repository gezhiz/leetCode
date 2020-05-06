package com.gerson.design.reconstruct.metrics.needrecon.storage;

import com.gerson.design.reconstruct.metrics.needrecon.entity.RequestInfo;

import java.util.List;
import java.util.Map;

/**
 * @author gezz
 * @description
 * @date 2020/5/6.
 */
public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);

    List getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}
