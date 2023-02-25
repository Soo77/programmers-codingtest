package com.codingtest.practice.Java3rdEdition.exercise.Ex06;

public class Ex6_6 {
    // (x,y) (x1,y1) . 두 점 와 간의 거리를 구한다
    static double getDistance(int x, int y, int x1, int y1) {
        return Math.sqrt((x1-x)*(x1-x) + (y1-y)*(y1-y));
    }

    public static void main(String[] args) {
        System.out.println(getDistance(1,1,2,2));
    }
}
