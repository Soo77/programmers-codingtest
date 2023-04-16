package com.codingtest.practice.Java3rdEdition.exercise.Ex07;

abstract class Unit {
    int x, y; // 현재 위치
    abstract void move(int x, int y);
    void stop() { /* 현재 위치에 정지*/ }
}
class Marine extends Unit { // 보병
    void stimPack() { /* 스팀팩을 사용한다.*/}

    @Override
    void move(int x, int y) {

    }
}
class Tank extends Unit{ // 탱크
    void changeMode() { /*공격모드를 변환한다 . */}

    @Override
    void move(int x, int y) {

    }
}
class Dropship extends Unit{ // 수송선
    void load() { /*선택된 대상을 태운다 .*/ }
    void unload() { /* 선택된 대상을 내린다.*/ }

    @Override
    void move(int x, int y) {

    }
}


public class Ex7_16 {
}
