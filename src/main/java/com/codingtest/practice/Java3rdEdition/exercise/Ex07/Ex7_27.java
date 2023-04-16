package com.codingtest.practice.Java3rdEdition.exercise.Ex07;

class Outer {
    int value=10;
    class Inner {
        int value=20;
        void method1() {
            int value=30;
            System.out.println(/* (1) */ value);
            System.out.println(/* (2) */ this.value);
            System.out.println(/* (3) */ Outer.this.value);
        }
    } // Inner클래스의 끝
} // Outer클래스의 끝
public class Ex7_27 {
    public static void main(String args[]) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method1();
    }
}
