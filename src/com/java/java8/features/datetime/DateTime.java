package com.java.java8.features.datetime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class DateTime {
    public static void main(String[] args) {
        //Pre-Java 8
        System.out.println("1.Before Java 8-----------------------------------------");
        Date d1 = new Date();
        System.out.println("2."+d1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        System.out.println("3."+simpleDateFormat.format(d1));

        java.sql.Date d2 = new java.sql.Date(d1.getTime());
        System.out.println("4."+d2);

        //Java-8
        System.out.println("Java 8-----------------------------------------");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(LocalDate.of(1988, 03, 13));

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(LocalTime.of(23,35,56));
    }
}
