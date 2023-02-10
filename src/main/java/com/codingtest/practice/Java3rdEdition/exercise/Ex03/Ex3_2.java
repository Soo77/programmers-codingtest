package com.codingtest.practice.Java3rdEdition.exercise.Ex03;

public class Ex3_2 {
    public static void main(String[] args) {
        int numOfApples = 123; // 사과의 개수
        int sizeOfBucket = 10;
        int numOfBucket
                = numOfApples/sizeOfBucket
                + (numOfApples%sizeOfBucket > 0 ? 1 : 0);

        System.out.println(numOfBucket);
    }
}
