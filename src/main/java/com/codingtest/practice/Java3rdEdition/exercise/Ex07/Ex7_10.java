package com.codingtest.practice.Java3rdEdition.exercise.Ex07;
/*
*
* 7-12
* c
* 7-13
* Math클래스 안에는 모든 메서드가 static 메서드이고 인스턴수변수가 없기떄ㅜㅁㄴ에
* 객체를 생성할 필요가 없기떄문ㅇ
*
*
* 답지>> Math클래스의 모든 메서드가 static 메서드이고 인스턴스변수가
* 존재하지 않기 때문에 객체를 생성할 필요가 없기 때문.
*
*
* */
class MyTv2 {
    boolean isPowerOn;
    int channel;
    int volumne;
    int prev;

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        if(channel < MIN_CHANNEL || channel > MAX_CHANNEL) return;
        System.out.println("이전채널:"+this.channel);
        this.prev = this.channel;
        System.out.println("바꿀채널:"+channel);
        this.channel = channel;
    }

    public int getVolume() {
        return volumne;
    }

    public void setVolume(int volumne) {
        if(MIN_VOLUME < 0 || MAX_VOLUME > 100) return;
        this.volumne = volumne;
    }

    public void gotoPrevChannel() {
        setChannel(prev);
    }
}

public class Ex7_10 {
    public static void main(String[] args) {

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
