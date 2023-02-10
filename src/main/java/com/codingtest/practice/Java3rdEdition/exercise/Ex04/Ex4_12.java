package com.codingtest.practice.Java3rdEdition.exercise.Ex04;

public class Ex4_12 {
    public static void main(String[] args) {
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=3; j++) {
                int x = j+1+(i-1)/3*3;
                int y = i%3==0? 3: i%3;
                if(x>9)break;

                System.out.print(x+ "*" + y + "=" +(x*y) + "\t");


                /*System.out.println("j+1:"+(j+1));
                System.out.println("i-1:"+(i-1));
                System.out.println("(i-1)/3: "+(i-1)/3);
                System.out.println("j+1 + (i-1)/3: "
                + (j+1 + (i-1)/3));
                System.out.println("j+1+(i-1)/3*3: "
                + (j+1+(i-1)/3*3));
                System.out.println((j+1)+(i-1)/3*3);
                System.out.println();*/


            }
            System.out.println();
            if(i%3==0) System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
