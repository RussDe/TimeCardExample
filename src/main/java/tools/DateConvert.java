package tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Format from String to Date
 */
public class DateConvert {
    public static Date convertToDate(String date) throws ParseException {

        //define Date Format
        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        return dateFormat.parse(date);

    }
}
