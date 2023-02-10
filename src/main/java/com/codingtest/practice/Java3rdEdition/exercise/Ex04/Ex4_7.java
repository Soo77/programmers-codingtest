package com.codingtest.practice.Java3rdEdition.exercise.Ex04;

public class Ex4_7 {
    public static void main(String[] args) {
        int value = 0;
        for(int i=0; i<20; i++) {
            value = (int)(Math.random()*6)+1;
            System.out.print(value + ", ");
        }
        System.out.println(value);
    }
}
