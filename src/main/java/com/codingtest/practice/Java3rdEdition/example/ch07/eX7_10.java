package com.codingtest.practice.Java3rdEdition.example.ch07;

public class eX7_10 {

    public static void main(String[] args) {
        Unit[] group = {new Marine(), new Tank(), new Dropship()};
        /*
         * 위 한줄과 같은 코드
         * Unit[] group = new Unit[3];
         * group[0] = new Marine();
         * group[1] = new Tank();
         * group[2] = new Dropship();
         * */
        for(int i=0; i<group.length; i++) {
            group[i].move(100, 200);
        }
        for(int i=0; i<group.length; i++) {
            group[i].stop();
        }
    }
}

abstract class Unit {
    int x, y;
    abstract void move(int x, int y);
    void stop() { /* 현재 위치에 정지 */ System.out.println("현재 위치에 정지");}
}

class Marine extends Unit {

    void move(int x, int y) {
        System.out.println("Marine[x="+ x + ", y=" + y + "]");
    }
    void stimPack() { /* 스팀팩을 사용한다. */ System.out.println("스팀팩을 사용한다.");}
}

class Tank extends Unit {

    void move(int x, int y) {
        System.out.println("Tank[x="+x+", y="+y+"]");
    }
}

class Dropship extends  Unit {
    void move(int x, int y) {
        System.out.println("Dropship[x=" + x + ", y=" + y + "]");
    }
}