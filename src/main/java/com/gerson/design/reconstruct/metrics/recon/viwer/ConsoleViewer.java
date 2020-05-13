package com.gerson.design.reconstruct.metrics.recon.viwer;

import com.gerson.design.reconstruct.metrics.recon.entity.RequestStat;
import com.google.gson.Gson;

import java.util.Map;

/**
 * @author gezz
 * @description
 * @date 2020/5/6.
 */

/**
 * 打印控制台的方式
 * 如果打印控制台的方式不想使用json格式，那么就需要将output的代码进一步进行抽象，抽象出一个接口，针对RequestStats对象进行处理的接口
 */
public class ConsoleViewer implements StatViewer {

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMills + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}
