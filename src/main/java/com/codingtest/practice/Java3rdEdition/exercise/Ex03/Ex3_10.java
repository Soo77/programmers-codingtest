package com.codingtest.practice.Java3rdEdition.exercise.Ex03;

public class Ex3_10 {
    public static void main(String[] args) {
        char ch = 'A';

        char lowerCase = ('A' <= ch || ch <= 'Z') ? (char)(ch + 32) : ch;

        System.out.println("ch:"+ch);
        System.out.println("ch to lowerCase:"+lowerCase);
    }
}
