package com.codingtest.practice.Java3rdEdition.exercise.Ex07;
/*
* e
*
* */
public class Ex7_22 {
    public static void main(String[] args) {

        Shape[] arr = {new Circle(5.0), new Rectangle(3,4), new Circle(1)};
        System.out.println(" :"+sumArea(arr));
    }

    private static double sumArea(Shape[] arr) {
        double result = 0.0;
        for(int i=0; i<arr.length; i++) {
            Shape shape = arr[i];
            result += shape.calcArea();
        }
        return result;
    }
}

abstract class Shape {
    Point p;
    Shape() {
        this(new Point(0,0));
    }
    Shape(Point p) {
        this.p = p;
    }
    abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드
    Point getPosition() {
        return p;
    }
    void setPosition(Point p) {
        this.p = p;
    }
}

class Circle extends Shape {
    double r;

    Circle(double r) {
        this(new Point(0,0), r);
    }

    public Circle(Point point, double r) {
        super(point);
        this.r = r;
    }

    @Override
    double calcArea() {
        return r*r*Math.PI;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(double width, double height) {
        this(new Point(0,0), width, height);
    }

    public Rectangle(Point point, double width, double height) {
        super(point);
        this.width = width;
        this.height = height;
    }

    @Override
    double calcArea() {
        return width*height;
    }

    boolean isSquare() {
        return (width*height != 0) && (width == height);
    }


}

class Point {
    int x;
    int y;
    Point() {
        this(0,0);
    }
    Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
    public String toString() {
        return "["+x+","+y+"]";
    }
}