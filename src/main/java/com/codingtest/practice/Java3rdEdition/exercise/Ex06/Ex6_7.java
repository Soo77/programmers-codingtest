package com.codingtest.practice.Java3rdEdition.exercise.Ex06;

class MyPoint {
    int x;
    int y;

    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(int x1, int y1) {
        return Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
    }
}

public class Ex6_7 {
    public static void main(String[] args) {
        MyPoint p = new MyPoint(1,1);
        // p (2,2) . 와 의 거리를 구한다
        System.out.println(p.getDistance(2,2));
    }
}
