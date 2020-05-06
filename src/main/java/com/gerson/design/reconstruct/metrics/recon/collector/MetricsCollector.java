package com.gerson.design.reconstruct.metrics.recon.collector;

import com.gerson.design.reconstruct.metrics.recon.entity.RequestInfo;
import com.gerson.design.reconstruct.metrics.recon.storage.MetricsStorage;
import org.apache.commons.lang.StringUtils;

/**
 * @author gezz
 * @description
 * @date 2020/5/6.
 */
public class MetricsCollector {
    private MetricsStorage metricsStorage;//基于接口而非实现编程 //依赖注入

    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    //用一个函数代替了最小原型中的两个函数
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
