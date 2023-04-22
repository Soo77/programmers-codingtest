package com.codingtest.practice.Java3rdEdition.exercise.Ex10;

import java.text.DecimalFormat;

public class Excercise10_3 {

    public static void main(String[] args) {

        String data = "123,456,789.5";

        DecimalFormat df = new DecimalFormat("#,###.##");
        DecimalFormat df2 = new DecimalFormat("#,####");

        try {
            double d = df.parse(data).doubleValue();

            System.out.println(data);
            System.out.println(Math.round(d));
            System.out.println(df2.format(d));

        }catch(Exception e) {}
    }
}
