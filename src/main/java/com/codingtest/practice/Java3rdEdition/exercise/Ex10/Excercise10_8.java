package com.codingtest.practice.Java3rdEdition.exercise.Ex10;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Excercise10_8 {
    //America/New_York

    public static void main(String[] args) {

        ZonedDateTime zdt = ZonedDateTime.now();
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime zdtNY = ZonedDateTime.now().withZoneSameInstant(zoneId);

        System.out.println(zdt);
        System.out.println(zdtNY);

        long sec1 = zdt.getOffset().getTotalSeconds();
        long sec2 = zdtNY.getOffset().getTotalSeconds();
        long diff = (sec1 - sec2) / 3600;

        System.out.printf("diff=%d hrs %n",diff);



    }


}
