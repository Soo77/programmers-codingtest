package com.codingtest.practice.Java3rdEdition.exercise.Ex07;
/*
*
* 7-12 c 접근제어자가 사용될 수 있는 곳: 클래스, 멤버변수, 메서드, 생성자
* 7-13 Math 클래스의 생성자는 접근제어자가 private이다. 이유는?
* Math클래스의 모든 메서드가 static메서드이고 인스턴스 변수가 존재하지 않기
* 때문이다. Math클래스는 몇개의 상수와 static메서드만으로 구성되어 있기 때문에
* 인스턴스를 생성할 필요가 없다. 그래서 외부로부터의 불필요한 접근을 막기위해
* 다음과같이 생성자의 접근 제어자를 private로 지정하였다.
* public final class Math {
*   private Math() {}
* }
*
*
*
*
* */
class MyTv2 {
    private boolean isPowerOn;
    private int channel;
    private int volume;
    private int prevChannel;

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    public int getChannel() {
        return channel;
    }
    public void setChannel(int channel) {
        if(channel > MAX_CHANNEL || channel < MIN_CHANNEL) return;

        prevChannel = this.channel;
        this.channel = channel;
    }
    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        if(volume > MAX_VOLUME || volume < MIN_VOLUME) return;
        this.volume = volume;
    }
    public void gotoPrevChannel() {
        setChannel(prevChannel);
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
        t.gotoPrevChannel();;
        System.out.println("CH:"+t.getChannel());
    }
}
