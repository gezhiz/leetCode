package com.gerson.design.reconstruct.metrics.recon.viwer;

import com.gerson.design.reconstruct.metrics.recon.entity.RequestStat;

import java.util.Map;

/**
 * @author gezz
 * @description
 * @date 2020/5/6.
 */
public interface StatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills);
}
