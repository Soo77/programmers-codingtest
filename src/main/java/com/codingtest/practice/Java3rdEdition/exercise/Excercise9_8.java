package com.codingtest.practice.Java3rdEdition.exercise;

/*
*  주어진 값을 반올림하여 소수점 이하 자리의 값을 반환한다.
예를 들어 n의 값이 3이면 소수점 4째 자리에서 반올림하여 소수점 이하 3자리의 수를 반환한다.
* */
public class Excercise9_8 {

    private static double round(double d, int n) {

        double temp = d * Math.pow(10,n);
        temp = Math.round(temp);
        temp /= Math.pow(10,n);
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(round(3.1415,1));
        System.out.println(round(3.1415,2));
        System.out.println(round(3.1415,3));
        System.out.println(round(3.1415,4));
        System.out.println(round(3.1415,5));
    }

}
