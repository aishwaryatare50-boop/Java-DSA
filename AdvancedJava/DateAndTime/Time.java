package AdvancedJava.DateAndTime;

public class Time {
    public static void main(String[] args) {
        System.out.println("No. of years since 1970: " + System.currentTimeMillis()/1000/3600/24/365);
        System.out.println("No of days passed since 1970: " + System.currentTimeMillis()/1000/3600/24);
    }
}
