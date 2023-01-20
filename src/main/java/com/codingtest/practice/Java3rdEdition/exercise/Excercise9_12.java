package com.codingtest.practice.Java3rdEdition.exercise;

/*
*
*
 * */
public class Excercise9_12 {


    private static int getRand(int from, int to) {
        return (int)(Math.random() * (Math.abs(to-from)+1))+ Math.min(from,to);
              //  + Math.min(from,to);
    }


    public static void main(String[] args) {
        for(int i=0; i<20; i++) {
            System.out.print(getRand(3,-7)+",");
        }

    }



}
