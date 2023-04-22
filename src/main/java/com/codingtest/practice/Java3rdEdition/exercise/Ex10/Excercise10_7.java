package com.codingtest.practice.Java3rdEdition.exercise.Ex10;

import java.time.LocalDate;

import static java.time.DayOfWeek.*;
import static java.time.temporal.TemporalAdjusters.dayOfWeekInMonth;

public class Excercise10_7 {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2016,12,1);
        System.out.println(date.with(dayOfWeekInMonth(4,TUESDAY)));
    }


}
