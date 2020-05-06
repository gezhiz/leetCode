package com.gerson.design.reconstruct.metrics.recon.repoter;

import com.gerson.design.reconstruct.metrics.recon.aggregate.Aggregator;
import com.gerson.design.reconstruct.metrics.recon.storage.MetricsStorage;
import com.gerson.design.reconstruct.metrics.recon.viwer.StatViewer;
import com.google.common.annotations.VisibleForTesting;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author gezz
 * @description
 * @date 2020/5/6.
 */
public class EmailReporter extends AbsReporter {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
    }

    public void startDailyReport() {
        Date firstTime = trimTimeFieldsToZeroOfNextDay(new Date());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 省略其他代码...
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                doStatAndReport(startTimeInMillis, endTimeInMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }

    // 设置成protected而非private是为了方便写单元测试
    @VisibleForTesting
    protected Date trimTimeFieldsToZeroOfNextDay(Date date) {
        // 这里可以获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}