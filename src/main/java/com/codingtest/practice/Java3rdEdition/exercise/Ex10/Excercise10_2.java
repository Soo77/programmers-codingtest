package com.codingtest.practice.Java3rdEdition.exercise.Ex10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Excercise10_2 {

    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();

        cal.set(2010,0,1);


        for(int i=0; i<12; i++) {
            int weekday = cal.get(Calendar.DAY_OF_WEEK);

            int secondSunday = (weekday==1) ? 8 : 16 - weekday;

            cal.set(Calendar.DAY_OF_MONTH, secondSunday);
            Date d = cal.getTime();
            System.out.println(new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일입니다." +
                    "G연대, 년의 w번째주, 월의 W번째주, 월의 d번째일, a는 오전오후," +
                    "\n, H는 시간 m분 s초, z, Z").format(d));

            cal.add(Calendar.MONTH,1);
            cal.set(Calendar.DAY_OF_MONTH,1);
        }


    }
}
