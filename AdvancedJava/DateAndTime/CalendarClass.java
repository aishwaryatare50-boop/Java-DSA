package AdvancedJava.DateAndTime;

import java.util.Calendar;
import java.util.TimeZone;

public class CalendarClass {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.getCalendarType());
        System.out.println(c.getTimeZone());
        System.out.println(c.getTime());
        System.out.println(c.get(Calendar.DATE));
        System.out.println((c.get(Calendar.SECOND)));
        System.out.println(c.get(Calendar.HOUR));
        System.out.println(c.get(Calendar.HOUR_OF_DAY));

        Calendar c2 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Singapore"));
        System.out.println(c2.getCalendarType());
        System.out.println(c2.getTimeZone());
        System.out.println(c.getTime());
    }
}