package com.codingtest.practice.Java3rdEdition.exercise.Ex07;
/*
* 7-6 자손 클래스의 생성자에서 조상 클래스의 생성자를 호출해야하는 이유는
* 무엇인가?
* >> 조상클래스를 상속받으면 조상에 정의된 인스턴스 변수들이
* 또한 초기화해야하는데,
* 조상생성자에서 초기화하는 것이 바람직해서.
*
*
* >> 조상에 정의된 인스턴스 변수들이 초기화되도록 하기 위해서
* >> 자손클래스의 인스턴스를 생성하면 조상으로부터 상속받은 인스턴스변수들도
* 생성되는데, 이 상속받은 인스턴스변수들 역시 적절히 초기되어야한다.
* 상속받은 조상의 인스턴스 변수들을 자손의 생성자에서 직접 초기화하기 보다는
* 조상의 생성자를 호출함으로써 초기화 되도록 하는 것이 바람직하다.
* 각 클래스의 생성자는 해당 클래스에 선언된 인스턴스 변수의 초기화만을
* 담당하고, 조상 클래스로부터 상속받은 인스턴스 변수 초기화는 조상클래스의
* 생성자가 처리하도록 하는 것이다.
*
* 7-7
* 100
* >>내답child() -> Parent()
* >>답지
* Child() ->. Child(int x) -> Parent() -> Parent(int x) -> Object()
*
* 7-8
* public-protected-default-private
*
* 7-9
* final
* final + 클래스: 변경될 수 없는 클래스. 확장될 수 없는 클래스.
* 다른 클래스의 조상이 될 수 없다.
* final + 메서드 : 변경될 수 없는 메서드. 오버라이딩 통해 재정의 될 수 없다.
* final + 멤버변수,지역변수: 값을 변경할 수 없는 상수가 된다.
* */
class Product {
    int price;
    int bonusPoint;

    Product() {}

    Product(int price) {
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
}

class Tv extends Product {
    Tv() {}

    public String toString() {
        return "Tv";
    }
}

public class Ex7_5 {
    public static void main(String[] args) {
        Tv t = new Tv();
    }
}
