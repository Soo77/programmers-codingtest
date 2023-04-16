package com.codingtest.practice.Java3rdEdition.exercise.Ex07;
/*
*
* 100
* Parent Method
* 200
* Parent Method
*
* 조상 클래스에 선언된 멤버변수와 같은 이름의 인스턴스 변수를 자손클래스에 중복으로 정의했을때,
* 조상타입의 참조변수로 자손 인스턴스를 참조하는 경우와 자손타입의 참조변수로 자손 인스턴스를
* 참조하는 경우는 서로 다른 결과를 얻는다.
*
* 메서드의 경우 조상 클래스의 메서드를 자손의 클래스에서 오버라이딩한 경우에도 참조변수의 타입에
* 관계없이 항상 실제 인스턴스의 메서드가 호출되지만, 멤버변수의 경우 참조변수의 타입에 따라 달라진다.
*
/*

public class Ex7_20 {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();
        System.out.println("p.x = " + p.x);
        p.method();
        System.out.println("c.x = " + c.x);
        c.method();
    }
}
class Parent {
    int x = 100;
    void method() {
        System.out.println("Parent Method");
    }
}
class Child extends Parent {
    int x = 200;
    void method() {
        System.out.println("Child Method");
    }
}
*/
