package tools;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Compare dates
 */
public class DateCompare {

    //check if the report needs to be submitted
    public static boolean needToSubmit(Date cardDay, int gapDays) throws ParseException {

        Date today = new Date();
        return (getGapInDays(cardDay, today) >= gapDays);
    }

    public static long getGapInDays(Date lastDay, Date today) {
        long diff = today.getTime() - lastDay.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

}