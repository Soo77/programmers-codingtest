package com.codingtest.practice.Java3rdEdition.example.ch09;

import java.math.BigDecimal;

public class Ex9_12 {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("01");
        StringBuffer sb2 = sb.append(23);
        sb.append('4').append(56);

        StringBuffer sb3 = sb.append(78);
        sb3.append(9.0);

        System.out.println("sb = "+sb);
        System.out.println("sb2 = "+sb2);
        System.out.println("sb3 = "+sb3);

        System.out.println("sb = " + sb.deleteCharAt(10)); //01234567890
        System.out.println("sb = " + sb.delete(3,6)); //01267890
        System.out.println("sb = " + sb.insert(3,"abc")); //012abc67890
        System.out.println("sb = " + sb.replace(6, sb.length(), "END")); //012abcEND

        System.out.println("capacity = " + sb.capacity());//16
        System.out.println("length = " + sb.length()); //9

        double a = 90.7552;
        System.out.println(a);
        a *= 100;
        System.out.println(a);
        a = Math.round(a);
        System.out.println(a);
        a /= 100.0;
        System.out.println(a);

        BigDecimal d =  new BigDecimal("10.00000000000000000000000000000000000000000000000000000000000015");
        //Math.ceil(d);
        System.out.println(d);

        double d2 = Math.ceil(-10.1);
        double d3 = Math.floor(-10.1);
        System.out.println(d2 + ", "+d3);

        System.out.println(Math.rint(2.5));
        System.out.println(Math.round(2.5));

        int i = new Integer("100").intValue();
        int i2 = Integer.parseInt("100");
        Integer i3 = Integer.valueOf("00");

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);

        byte bb = Byte.parseByte("100");
        byte bb2 = Byte.valueOf("100");
        Byte bb3 = Byte.valueOf("100");
        Byte bb4 = Byte.parseByte("100");

        System.out.println(bb);
        System.out.println(bb2);
        System.out.println(bb3);
        System.out.println(bb4);
    }
}
