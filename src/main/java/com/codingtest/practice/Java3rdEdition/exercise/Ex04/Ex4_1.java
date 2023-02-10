package com.codingtest.practice.Java3rdEdition.exercise.Ex04;

public class Ex4_1 {
    public static void main(String[] args) {
        int x = 10;
        char ch = ' ';
        int year = 1000;
        boolean powerOn = false;
        String str = "yes";
        System.out.println(10 < x && x < 20);
        System.out.println(ch != ' ' && ch != '\t');
        System.out.println('0' <= ch && ch <= '9');
        System.out.println(('A' <= ch && ch <= 'Z')
            || ('a' <= ch && ch <= 'z'));
        System.out.println(year%400 == 0 || year%4==0 && year%100!=0);
        System.out.println(!powerOn);
        System.out.println();

    }
}
