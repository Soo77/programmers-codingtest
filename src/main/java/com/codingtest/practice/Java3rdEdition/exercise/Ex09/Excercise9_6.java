package com.codingtest.practice.Java3rdEdition.exercise.Ex09;

import java.util.Arrays;

public class Excercise9_6 {
   public static String fillZero(String src, int length) {
       if(src == null || src.length() == length) {
           return src;
       } else if(length <= 0) {
           return "";
       } else if(src.length() > length) {
           return src.substring(0,length);
       }
       char[] c = new char[length];
       Arrays.fill(c,'0');
       //답지참고
       System.arraycopy(src.toCharArray(), 0, c, length - src.length(), src.length());


       return new String(c);
   }

    public static void main(String[] args) {
        String src = "12345";
        System.out.println(fillZero(src,10));
        System.out.println(fillZero(src,-1));
        System.out.println(fillZero(src,3));
    }
}
