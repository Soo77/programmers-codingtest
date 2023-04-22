package com.codingtest.practice.Java3rdEdition.exercise.Ex10;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Excercise10_6 {

    public static void main(String[] args) {

//        Calendar birthDay = Calendar.getInstance();
//        //birthDay.set(2000,0,28);
//        birthDay.set(2000,0,1);
//
//        Calendar toDay = Calendar.getInstance();
//        //toDay.set(2016,0,29);
//
//        System.out.println(birthDay.getTimeInMillis());
//        System.out.println(toDay.getTimeInMillis());
//
//        System.out.println((toDay.getTimeInMillis() - birthDay.getTimeInMillis()) / (24*60*60*1000));

        LocalDate birthDay = LocalDate.of(2000,01,28);
        LocalDate now = LocalDate.now();

        long days = birthDay.until(now, ChronoUnit.DAYS);

        System.out.println(days);
    }


}
