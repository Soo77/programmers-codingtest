package com.codingtest.practice.Java3rdEdition.exercise.Ex07;

/*
* 7-6
* 자손클래스의 생성자에서 조상의 클래스의 생성자를 호출해야하는 이유?
* 조상에 정의된 인스턴스 변수들이 추기화되도록 하기 위해서..
* 
*
*
*
* */

class Product
{
    Product() {}
    int price; // 제품의 가격
    int bonusPoint; // 제품구매 시 제공하는 보너스점수
    Product(int price) {
        this.price = price;
        bonusPoint =(int)(price/10.0);
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
