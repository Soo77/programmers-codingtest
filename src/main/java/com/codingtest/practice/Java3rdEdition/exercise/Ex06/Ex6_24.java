package com.codingtest.practice.Java3rdEdition.exercise.Ex06;


/*
* 객관식문제
* 6-10
* b,e
* 생성자도 오버로딩이 가능해서 하나의 클래스에 여러 생성자를 정의할 수 있다.
*
* 6-11
* b
* this는 인스턴스 자신의 주소를 저장하고 있으며, 모든 인스턴스메서드에 숨겨진채로 존재하는
* 지역변수이다. 그래서 인스턴스메서드 내에서만 사용할 수 있다.
*
* 6-12
* c,d
*
* 6-13
* b,c,d
*
* 6-14
* c,e
* 클래스변수는 클래스가 처음 메모리에 로딩될때 자동 초기화됨.
*
* 6-15
* a
* 기본값-명시적초기화-초기화블럭-생성자
*
* 6-16
* a,e
* 지역변수는 자동 초기화 되지 않기때문에 사용하기 전에 바드시 적절한 값으로 초기화
* 힙영역에는 인스턴스가 생성되는 영역이며, 지역변수는 호출스택(call stack)에 생성된다.
*
* 6-17
* b
*
* 6-18
* a,b,d
* 스태틱변수 초기화에 인스턴스변수를 사용할수없다.
* 스태틱 메서드는 인스턴스 변수 사용할수없다.
* 스태틱 메서드는 인스턴스 메서드 사용할수없다.
*
*
* */
public class Ex6_24 {

    static private int abs(int value) {
        return (value < 0 ? -value : value);
    }

    public static void main(String[] args) {
        int value = 5;
        System.out.println(value+"의 절대값:"+abs(value));
        value = -10;
        System.out.println(value+"의 절대값:"+abs(value));
    }

}
