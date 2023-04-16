package com.codingtest.practice.Java3rdEdition.exercise.Ex07;

/*
* 호출되는 생성자의 순서?
* 컴파일러는 생성자의 첫줄에 다른 생성자를 호출하지 않으면 조상의 기본 생성자를 호출하는
* 코드 super() 를 넣는다.
* Child() -> Child(int x) -> Parent() -> Parent(int x) -> Object()
*
* 7-8
* a
*
* 7-9
* c
* final을 붙이면?
* 클래스: 변경될 수 없는 클래스, 확장될 수 없는 클래스가 된다. 그래서 final로 지정된 클래스는
* 다른 클래스의 조상이 될 수 없다.
* 메서드: 변경될 수 없는 메서드. final로 지정된 메서드는 오버라이딩을 통해 재정의 될 수 없다.
* 멤버,지역변수: 변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다.
*
*
*
* */

class Parent {
    int x=100;
    Parent() {
        this(200);
    }
    Parent(int x) {
        this.x = x;
    }
    int getX() {
        return x;
    }
}
class Child extends Parent {
    int x = 3000;
    Child() {
        this(1000);
    }
    Child(int x) {
        this.x = x;
    }
}
class Ex7_7 {
    public static void main(String[] args) {
        Child c = new Child();
        System.out.println("x="+c.getX());
    }
}
