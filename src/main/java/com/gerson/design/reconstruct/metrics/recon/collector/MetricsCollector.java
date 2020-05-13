package com.gerson.design.reconstruct.metrics.recon.collector;

import com.gerson.design.reconstruct.metrics.recon.entity.RequestInfo;
import com.gerson.design.reconstruct.metrics.recon.storage.MetricsStorage;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.apache.commons.lang.StringUtils;

import java.util.EventListener;
import java.util.concurrent.Executors;

/**
 * @author gezz
 * @description
 * @date 2020/5/6.
 */
public class MetricsCollector {

    private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 20;
    /**
     * 基于接口而非实现编程
     * 依赖注入
     */
    private MetricsStorage metricsStorage;

    private EventBus eventBus;

    // 提供默认构造函数，提现代码的易用性
    public MetricsCollector(MetricsStorage metricsStorage) {
        this(metricsStorage, DEFAULT_STORAGE_THREAD_POOL_SIZE);
    }

    public MetricsCollector(MetricsStorage metricsStorage, int threadNumToSaveData) {
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadNumToSaveData));
        //注册eventBus的消费对象
        eventBus.register(new EventListener() {
            @Subscribe
            public void saveRequestInfo(RequestInfo requestInfo) {
                metricsStorage.saveRequestInfo(requestInfo);
            }
        });
    }

    /**
     * @param requestInfo
     */
    @Deprecated
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        //本采集方法是非主要业务，需要进行异步化,使用队列来实现异步化
        //metricsStorage.saveRequestInfo(requestInfo);
        // 使用Guava的EventBus来维护队列，并针对队列的内容进行消费
        eventBus.post(requestInfo);
    }
}
