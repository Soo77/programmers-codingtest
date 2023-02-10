package com.codingtest.practice.Java3rdEdition.exercise.Ex04;

public class Ex4_8 {
    public static void main(String[] args) {
        int x, y;
        for(int i=0; i<=10; i++) {
            for(int j=0; j<=10; j++) {
                if(2*i + 4*j == 10) {
                    System.out.print(i + ","+ j);
                }
            }
            System.out.println();
        }
    }
}
