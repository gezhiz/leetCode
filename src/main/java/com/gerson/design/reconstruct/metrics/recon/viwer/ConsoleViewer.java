package com.gerson.design.reconstruct.metrics.recon.viwer;

import com.gerson.design.reconstruct.metrics.recon.entity.RequestStat;
import com.google.gson.Gson;

import java.util.Map;

/**
 * @author gezz
 * @description
 * @date 2020/5/6.
 */

public class ConsoleViewer implements StatViewer {

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMills + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}
