package com.codingtest.practice.Java3rdEdition.example.ch09;

import java.util.Objects;

class Card {
    String kind;
    int number;

    Card() {
        this("SPADE", 1);
    }

    Card(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    // equals()를 오버라이딩하면 hashCode()도 오버라이딩 해야한다.
    // iv가 같으면 해시코드 값이 같은 값이 나온다. => equals() 결과가 true면 해시코드 결과도 똑같이 나온다.
    public int hashCode() {
        return Objects.hash(kind, number);
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof Card))
            return false;

        Card card = (Card)obj;
        return card.kind.equals(this.kind) && card.number == this.number;
    }

    // Object클래스의 toString()을 오버라이딩
    public String toString() {
        return "kind:"+kind+", number:"+number;
    }
}

public class Ex9_4 {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        System.out.println(c1.equals(c2));

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}
