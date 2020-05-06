package com.gerson.design.reconstruct.metrics.recon.aggregate;

import com.gerson.design.reconstruct.metrics.recon.entity.RequestInfo;
import com.gerson.design.reconstruct.metrics.recon.entity.RequestStat;

import java.util.*;

/**
 * @author gezz
 * @description
 * @date 2020/5/6.
 */


public class DefaultAggregator extends AbsAggregator {

    @Override
    protected RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }

        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps((long) tps(respTimes.size(), durationInMillis/1000));
        return requestStat;
    }

    // 以下的函数的代码实现均省略...
    private double max(List<Double> dataset) {
        return 0;
    }
    private double min(List<Double> dataset) {
        return 0;
    }
    private double avg(List<Double> dataset) {
        return 0;
    }
    private double tps(int count, double duration) {
        return 0;
    }
    private double percentile999(List<Double> dataset) {
        return 0;
    }
    private double percentile99(List<Double> dataset) {
        return 0;
    }
    private double percentile(List<Double> dataset, double ratio) {
        return 0;
    }
}