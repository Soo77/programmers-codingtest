package com.codingtest.practice.Java3rdEdition.exercise.Ex10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Excercise10_2 {

    static int paycheckCount(Calendar from, Calendar to) {


        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        int fromDay = from.get(Calendar.DATE);

        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        int toDay = to.get(Calendar.DATE);

        int monDiff = (toYear * 12 + toMonth) - (fromYear * 12 + fromMonth);

        if(monDiff < 0) return 0;

        if(fromDay <= 21 && toDay >= 21) monDiff ++;
        if(fromDay > 21 && toDay < 21) monDiff -- ;


        return monDiff;
    }

    /*static void printResult(Calendar from, Calendar to) {
        Date fromDate = from.getTime();
        Date toDate = to.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print(sdf.format(fromDate) + "~"
                + sdf.format(toDate)+":");
        System.out.println(paycheckCount(from, to));
    }*/

    static void printResult(Calendar from, Calendar to) {
        Date fromDate = from.getTime();
        Date toDate = to.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print(sdf.format(fromDate)+" ~ "
                +sdf.format(toDate)+":");
        System.out.println(paycheckCount(from, to));
    }


    public static void main(String[] args) {
        Calendar fromCal = Calendar.getInstance();
        Calendar toCal = Calendar.getInstance();;


       fromCal.set(2010,0,1);
        toCal.set(2010,0,1);
        printResult(fromCal, toCal);
        fromCal.set(2010,0,21);
        toCal.set(2010,0,21);
        printResult(fromCal, toCal);

        fromCal.set(2010,0,1);
        toCal.set(2010,2,1);
        printResult(fromCal, toCal);
        fromCal.set(2010,0,1);
        toCal.set(2010,2,23);
        printResult(fromCal, toCal);
        fromCal.set(2010,0,23);
        toCal.set(2010,2,21);
        printResult(fromCal, toCal);
        fromCal.set(2011,0,22);
        toCal.set(2010,2,21);
        printResult(fromCal, toCal);

    }
}
