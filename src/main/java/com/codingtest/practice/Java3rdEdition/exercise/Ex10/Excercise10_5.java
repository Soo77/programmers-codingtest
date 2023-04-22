package com.codingtest.practice.Java3rdEdition.exercise.Ex10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Excercise10_5 {

    private static int getDayDiff(String yyyymmdd1, String yyyymmdd2) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Calendar fromCal = Calendar.getInstance();
        Calendar toCal = Calendar.getInstance();

        int diff = 0;

        try {

            Date fromDate = df.parse(yyyymmdd1);
            Date toDate = df.parse(yyyymmdd2);
            fromCal.setTime(fromDate);
            toCal.setTime(toDate);

            int fromYear = fromCal.get(Calendar.YEAR);
            int fromMon = fromCal.get(Calendar.MONTH);
            int fromDay = fromCal.get(Calendar.DAY_OF_MONTH);

            int toYear = toCal.get(Calendar.YEAR);
            int toMon = toCal.get(Calendar.MONTH);
            int toDay = toCal.get(Calendar.DAY_OF_MONTH);

            //fromCal.set(fromYear, fromMon, fromDay);
            //toCal.set(toYear, toMon, toDay);

            //System.out.println(fromYear +","+fromMon+","+fromDay);
            //System.out.println(toYear +","+toMon+","+toDay);

            diff = (int)((fromCal.getTimeInMillis() - toCal.getTimeInMillis()) / (24*60*60*1000));



        } catch(Exception e) {

            diff = 0;
        }

        return diff;

    }

    public static void main(String[] args) {

        System.out.println(getDayDiff("20010103","20010101"));
        System.out.println(getDayDiff("20010103","20010103"));
        System.out.println(getDayDiff("20010103","200103"));

    }


}
