package AdvancedJava.DateAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class JavaTime {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        System.out.println(d);

        LocalTime t = LocalTime.now();
        System.out.println(t);

        LocalDateTime dt = LocalDateTime.now(); // date
        System.out.println(dt);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-mm-yyyy -- E -- H:m a"); // formate
        String myDate = dt.format(df); // create date string from date and format
        System.out.println(myDate);

        DateTimeFormatter df2 = DateTimeFormatter.ISO_LOCAL_DATE;
        String myDate2 = dt.format(df2);
        System.out.println(myDate2);
    }    
}