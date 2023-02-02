/*
package com.codingtest.practice.Java3rdEdition.exercise.Ex07;
*/
/*
* 오버라이딩의 정의와 필요섣?
* 조상 클래스를 상속받아서 조상클래스에 있는 메서드와 선언부가 같은 메서드를 재정의하는것.
* 필요성은... 기능추가
*
* 답안지
* 조상클래스로부터 상속받은 메서드를 자손클래스에 맞게 재정의하는 것.
* 필요성: 조상클래스로부터 상속받은 메서드를 자손클래스에서 그대로 사용할 수 없는 경우가
* 많기 때문에 오버라이딩이 필요하다.
*
* 7-4 c,d
* 7-5
* 7-6 자손 클래스의 생성자에서 조상 클래스의 생성자를 호출해야하는 이유?
* >> 자손클래스의 인스턴스를 생성하면 조상으로부터 상속받은 인스턴스변수들도 생성되는데,
* 이 상속받은 인스턴스변수들 역시 적절히 초기화되어야한다. 상속받은 조상의
* 인스턴스변수들을 자손의 생성자에서 직접 초기화하기 보다는 저상의 생성자를 호출함으로써
* 초기화되도록 하는 것이 바람직하다.
* 각 클래스의 생성자는 해당 클래스에 선언된 인스턴스변수의 초기화만을 담당하고,
* 조상 클래스로부터 상속받은 인스턴스변수의 초기화는 조상클래스의 생성자가 처리하도록
* 해야하는 것이다.
*
* 7-7 호출되는 생성자의 순서와 실행결과를 적으시오.
* Child() -> Child(int x) -> Parent() -> Parent(int x) -> Object()의 순서
* 7-8 a
* 7-9 c 제어자 final은 마지막의 또는 변경될수없는 의 의미를 가지고 있으며
* 거의 모든 대상에 사용될 수 있다.
* final 클래스 : 변경될 수 없는 클래스, 확장될 수 없는 클래스가 된다.
* final 메서드 : 변경될 수 없는 메서드, 오버라이딩을 통해 재정의 될 수 없다.
* final 멤버변수, 지역변수 : 값을 변경할 수 없는 상수가 된다.
* *//*

class SutdaDeck {
    final int CARD_NUM=20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    SutdaDeck() {
        for(int i=0; i<cards.length; i++) {
            int num = i%10+1;
            boolean isKwang = (num>0) && (num==1 || num==3 || num==8);

            cards[i] = new SutdaCard(num, isKwang);
        }
    }

    void shuffle() {

        for(int i=0; i<cards.length; i++) {
            int j = (int)(Math.random()*cards.length);

            SutdaCard tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
    }

    SutdaCard pick(int index) {
        if(index < 0 || index >= CARD_NUM) return null;
        return cards[index];
    }

    SutdaCard pick() {
        int index = (int)(Math.random()*cards.length);
        return cards[index];
    }


}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1,true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

public class Ex7_1 {

    public static void main(String[] args) {
        SutdaDeck deck  = new SutdaDeck();

        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();

        for(int i=0; i<deck.cards.length; i++) {
            System.out.print(deck.cards[i]+",");
        }

        System.out.println();
        System.out.println(deck.pick(0));
    }
}
*/
