import com.gerson.design.testable.TimeTestable;
import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author gezz
 * @description
 * @date 2020/4/28.
 */
public class TimeTestableMock extends TimeTestable {


    @Override
    protected long getTimestamp() {
        TimeZone timeZone = TimeZone.getTimeZone("Asia/ShangHai");
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.clear();
        calendar.set(2020, Calendar.APRIL,28,0,0,0);
        return calendar.getTimeInMillis();

    }

    @Test
    public void testTestable() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse("2020-04-20");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long delayDays = caculateDelayDaysTestable(date);
        System.out.println(delayDays);
    }

    /**
     * 有问题的测试案例
     */
    @Deprecated
//    @Test
    public void testProblem() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse("2020-04-28");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long delayDays = caculateDelayDays(date);
        Assert.assertEquals(delayDays, 1L);
    }
}
