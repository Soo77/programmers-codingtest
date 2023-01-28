package com.codingtest.practice.Java3rdEdition.exercise.Ex09;

/*
* 다음과 같은 실행결과를 얻도록 클래스의 를 멤버변수인 SutdaCard equals() num,
isKwang . 의 값을 비교하도록 오버라이딩하고 테스트 하시오
* */
class Exercise9_1 {
    public static void main(String[] args) {
        SutdaCard c1 = new SutdaCard(3, true);
        SutdaCard c2 = new SutdaCard(3, true);

        System.out.println("c1="+c1);
        System.out.println("c2="+c2);
        System.out.println("c1.equals(c2) : "+ c1.equals(c2));
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

    public boolean equals(Object obj) {
        // 이건 내가 쓴 답이고
        /*if(!(obj instanceof SutdaCard))
            return false;

        SutdaCard card = (SutdaCard) obj;
        return card.num == this.num && card.isKwang == this.isKwang;*/

        // 이건 답안지 답
        if(obj instanceof SutdaCard) {
            SutdaCard c = (SutdaCard) obj;
            return num==c.num && isKwang==c.isKwang;
        }

        return false;
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}
