package com.codingtest.practice.Java3rdEdition.exercise.Ex07;

class Outer {
    class Inner {
        int iv = 200;
    }
}
public class Ex7_25 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner ii = outer.new Inner();

        Outer.Inner lll = new Outer().new Inner();
        System.out.println(lll.iv);
    }
}
