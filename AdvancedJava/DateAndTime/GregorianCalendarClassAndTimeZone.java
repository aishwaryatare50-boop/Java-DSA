package AdvancedJava.DateAndTime;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public class GregorianCalendarClassAndTimeZone {
    public static void main(String[] args) {
        GregorianCalendar cal = new GregorianCalendar();
        System.out.println(cal.isLeapYear(2026));

        System.out.println(TimeZone.getAvailableIDs()[0]);
        System.out.println(TimeZone.getAvailableIDs()[1]);
        System.out.println(TimeZone.getDefault());
    }
}