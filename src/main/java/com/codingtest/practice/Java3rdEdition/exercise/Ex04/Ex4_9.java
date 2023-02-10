package com.codingtest.practice.Java3rdEdition.exercise.Ex04;

public class Ex4_9 {
    public static void main(String[] args) {
        String str = "12345";
        int sum = 0;

        for(int i=0; i<str.length(); i++) {
            sum += str.charAt(i) - '0';
        }

        System.out.println("sum="+sum);
    }
}
/*
*
* 이항연산자는 int타입보다 작은 타입은 피연산자(byte,short,char)은 int로
* 변환한다. 그래서 '3'-'0'은 51-48으로 변환되고 그 결과는 숫자 3이 된다.
*
* */
