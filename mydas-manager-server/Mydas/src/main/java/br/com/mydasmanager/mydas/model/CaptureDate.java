package br.com.mydasmanager.mydas.model;

import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author Gabriela Garcia
 */
public class CaptureDate {

    static final Calendar CALENDAR = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));

    static final int HOUR = CALENDAR.get(Calendar.HOUR_OF_DAY);
    static final int MINUTE = CALENDAR.get(Calendar.MINUTE);

    static final int DAY = CALENDAR.get(Calendar.DATE);
    static final int MONTH = CALENDAR.get(Calendar.MONTH);
    static final int YEAR = CALENDAR.get(Calendar.YEAR);

    public static String selectDate() {
        return DAY + "/" + MONTH + "/" + YEAR + "-" + HOUR + ":" + MINUTE;
    }
}
