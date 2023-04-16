package com.codingtest.practice.Java3rdEdition.exercise.Ex07;

/*
* 7_12
* c
*
* 7_13
* Math클래스의 생성자는 접근제이저가 private인 이유?
* Math클래스는 몇개의 상수와 static 메서드만으로 구성되어 있기 때문
*
*
*
* */

class MyTv2 {
    boolean isPowerOn;
    int channel;
    int volume;
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;
    int prev;

    public void setChannel(int ch) {
        if(ch < MIN_CHANNEL || ch > MAX_CHANNEL) return;
        System.out.println("이전채널에"+ch+"저장"+ ", this.ch:"+this.channel);
        prev = this.channel;
        this.channel = ch;
    }

    public int getChannel() {
        return channel;
    }

    public void setVolume(int vol) {
        if(vol < MIN_VOLUME && vol > MAX_VOLUME) return;
        this.volume = vol;
    }

    public int getVolume() {
        return volume;
    }

    void gotoPrevChannel() {
        setChannel(prev);
    }
}
public class Ex7_10 {
    public static void main(String args[]) {
        MyTv2 t = new MyTv2();
        t.setChannel(10);
        System.out.println("CH:"+t.getChannel());
        t.setChannel(20);
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
    }
}