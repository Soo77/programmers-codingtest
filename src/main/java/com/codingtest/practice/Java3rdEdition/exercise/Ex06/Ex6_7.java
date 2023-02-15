package com.codingtest.practice.Java3rdEdition.exercise.Ex06;
/*///
*
* 클래스변수: width,height
* 인스턴스변수: kind,num
* 지역변수: k,n,args,card
*
* 6-9
* 땡
* weapon, armor
*
* 6-10
* 땡
*
* 6-11
* 땡
*
* 6-12
* c d
*
* 6-13
* bcd
*
* 6-14
* 땡
* 클래스 초기화
* 기본값 -> 명시적 초기화 -> 클래스 초기화블럭
* 인스턴스 초기화
* 기본값 -> 명시적 초기화 -> 인스턴스 초기화블럭-> 생성자
*
* 6-15
* a
*
* 6-16
* a 땡 하나더있음
*
* 6-17
* b,
*
* 6-18
* B, D
* 스태틱메서드에서 인스턴스 메서드,변수를 호출해서.
* A
* 스태틱변수 초기화에 인스턴스변수 사용못함.
*
* 6-19
* ABC123
* ABC123
*
*
*
*
*
*
* */
class MyPoint {
    int x;
    int y;
    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(int x1, int y1) {
        return Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
    }
    /*
    (1) getDistance . 인스턴스메서드 를 작성하시오
    */
}


public class Ex6_7 {
    public static void main(String args[]) {
        MyPoint p = new MyPoint(1,1);
// p (2,2) . 와 의 거리를 구한다
        System.out.println(p.getDistance(2,2));
    }
}
