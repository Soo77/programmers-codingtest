package com.codingtest.practice.Java3rdEdition.exercise.Ex10;

import java.text.DecimalFormat;

public class Excercise10_3 {



    public static void main(String[] args) {
     //  int num =123456790;
       // System.out.println(new DecimalFormat("#,####,####").format(num));

        String data = "123,456,789.5";
        DecimalFormat df = new DecimalFormat("#,###.##");
        DecimalFormat df2 = new DecimalFormat("#,####");

        try {
            Number num = df.parse(data);

            double d = num.doubleValue();
            System.out.println("data:"+data);
            System.out.println("반올림:"+Math.round(d));
            System.out.println("만단위:"+df2.format(d));

        } catch (Exception e) {

        }

    }
}
