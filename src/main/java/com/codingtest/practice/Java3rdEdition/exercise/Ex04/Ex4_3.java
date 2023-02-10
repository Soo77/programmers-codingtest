package com.codingtest.practice.Java3rdEdition.exercise.Ex04;

public class Ex4_3 {
    public static void main(String[] args) {
        int sum = 0;
        int totalSum = 0;
/*        for(int i=1; i<=10; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(j+"+");
                sum += j;
            }
            System.out.println();
        }*/
        for(int i=1; i<=10; i++) {
            sum += i;
            totalSum += sum;
            System.out.print(i);
            System.out.println(" "+sum);
            System.out.println(" "+totalSum);
        }
        System.out.println(sum);
    }

}
