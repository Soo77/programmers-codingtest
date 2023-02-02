package com.codingtest.practice.Java3rdEdition.exercise.Ex07;

/*
* 7-15 e 조상타입의 인스턴스를 자손타입으로 형변환 할 수 없다.
* 7-16 e
* instanceof연산자는 실제 인스턴스의 모든 조상이나 구현한 인터페이스에 대해
* true를 반환한다. 어떤 타입에 대해 instanceof연산결과가 true라는 것은
* 그 타입으로 형변환이 가능하다는 것을 뜻한다. 참조변수의
*
* */

class SutdaCard {
    final int NUM;
    final boolean IS_KWANG;

    SutdaCard() {
        this(1,true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.NUM = num;
        this.IS_KWANG = isKwang;
    }

    public String toString() {
        return NUM + (IS_KWANG ? "K" : "");
    }
}

public class Ex7_14 {
    public static void main(String[] args) {
        SutdaCard card = new SutdaCard(1,true);
    }
}
