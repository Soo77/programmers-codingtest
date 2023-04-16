/*
package com.codingtest.practice.Java3rdEdition.exercise.Ex07;

* 7-3 오버라이딩의 정의와 필요성?
* 오버라이딩이란 조상 클래스로부터 상속받은 메서드를 자손 클래스에 맞게 재정의 하는 것.
* 조상 클래스로부터 상속받은 메서드를 자손 클래스에서 그대로 사용할 수 없는 경우가 많기 때문에
* 오버라이딩이 필요하다.
*
* 7-4
* c,d
*
*


class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    SutdaDeck() {
        for(int i=0; i<20; i++) {
            int num = i%10 + 1;
            boolean isKwang = (i<10) && (num==1 || num==3 || num==8);
            cards[i] = new SutdaCard(num,isKwang);
        }
    }

   Ex7-2

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
        this(1, true);
    }
    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }
    // info() Object toString() . 대신 클래스의 을 오버라이딩했다
    public String toString() {
        return num + ( isKwang ? "K":"");
    }
}

public class Ex7_1 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();
        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();
        for(int i=0; i < deck.cards.length;i++)
            System.out.print(deck.cards[i]+",");
        System.out.println();
        System.out.println(deck.pick(0));
    }

}
*/
