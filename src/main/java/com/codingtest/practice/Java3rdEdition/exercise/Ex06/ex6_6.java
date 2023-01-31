package com.codingtest.practice.Java3rdEdition.exercise.Ex06;

class MyPoint {
    int x;
    int y;

    MyPoint(){}
    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double getDistance(int x1, int y1) {

        return Math.sqrt((x1-x)*(x1-x) + (y1-y)*(y1-y));
    }
}

public class ex6_6 {

/*    static double getDistance(int x, int y, int x1, int y1) {
        return Math.sqrt(Math.pow((x1-x),2) + Math.pow((y1-y), 2));
    }*/

    public static void main(String[] args) {
        MyPoint p = new MyPoint(1,1);

        System.out.println(p.getDistance(2,2));
    }

}
