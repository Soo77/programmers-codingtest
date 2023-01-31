package com.codingtest.practice.Java3rdEdition.exercise.Ex06;

// 이 클래스의 멤버 중 static을 붙여야 하는것? 그리고 이유?
// weapon, armor, weaponUp(), armorUp()
// 모든 Marine인스턴스에 대해 동일한 값이어야 하므로.
// 메서드 두개는 static 변수에 대한 작업을 하는 메서드 이므로.

/*
* 6-10 e,b
* 6-11 b
* 6-12 c,d
* 6-13 b, c, d
* 6-14 e,c
* 6-15 a
* 6-16 a,e
* 6-17 b
* 6-18 라인 b(인스턴스변수 사용해서) , 라인d(인스턴스메서드 사용해서)
* 라인 a(스태틱변수 초기화에 인스턴스변수 사용불가)
* 6-19
* ABC123
* After change:ABC123
* */
class Marine {
    int x=0, y=0;
    int hp=60;
    int weapon = 6;
    int armor = 0;

    void weaponUp() {

        weapon++;
    }

    void armorUp() {
        armor++;
    }

    void move(int x, int y) {
        this.x=x;
        this.y=y;
    }
}

public class ex6_9 {
}
