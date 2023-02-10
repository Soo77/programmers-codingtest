package com.codingtest.practice.Java3rdEdition.exercise.Ex04;

public class Ex4_4 {
    public static void main(String[] args) {
/*        int sum = 0;
        int i = 0;
        while (sum < 100) {
            System.out.println(i + ","+ sum);
            if(i%2 == 1) {
                sum += i;
            } else {
                sum += (-i);
            }
            if(sum >= 100) break;
            i++;
        }
        System.out.println("sum:"+sum);
        System.out.println(i);*/

        int sum = 0;
        int s = 1;
        int num = 0;

        for(int i=1; true; i++, s=-s) {
            System.out.println("s:"+s);
            num = s*i;
            sum += num;

            if(sum >= 100) break;
        }

        System.out.println("num="+num);
        System.out.println("sum="+sum);
    }
}
