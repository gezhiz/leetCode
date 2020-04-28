package com.gerson.design.testable;

import java.util.Date;

/**
 * @author gezz
 * @description
 * @date 2020/4/28.
 */
public class TimeTestable {

    /**
     * 可测试性差的代码
     * @param dueTime
     * @return
     */
    public long caculateDelayDays(Date dueTime) {
        //依赖于当前的时间,如果传入一个具体的时间，比如 new Date(2020,02,02)
        // 随着时间的变化，currentTimestamp发生变化，从而的到的结果会不一致。 currentTimestamp参数变得不可控制


        long currentTimestamp = System.currentTimeMillis();
        if (dueTime.getTime() >= currentTimestamp) {
            return 0;
        }
        long delayTime = currentTimestamp - dueTime.getTime();
        long delayDays = delayTime / 86400;
        return delayDays;
    }

    /**
     * 小技巧让时间可测
     * @see TimeTestableMock
     * @return
     */
    protected long getTimestamp() {
        return System.currentTimeMillis();
    }


    /**
     * 可测试性差的代码
     * @param dueTime
     * @return
     */
    public long caculateDelayDaysTestable(Date dueTime) {
        //依赖于当前的时间,如果传入一个具体的时间，比如 new Date(2020,02,02)
        // 随着时间的变化，currentTimestamp发生变化，从而的到的结果会不一致


        long currentTimestamp = getTimestamp();
        if (dueTime.getTime() >= currentTimestamp) {
            return 0;
        }
        long delayTime = currentTimestamp - dueTime.getTime();
        long delayDays = delayTime / 86400000;
        return delayDays;
    }

}
