package com.codingtest.practice.Java3rdEdition.exercise.Ex07;


    /*
    * 지역 클래스에서 외부 클래스의 인스턴스 멤버와 static 멤버에
    * 모두 접근할 수 있지만 지역변수는 final이 붙은 상수만
    * 접근할 수 있는 이유?
    *
    * 메서드가 수행을 마쳐서 지역변수가 소멸된 시점에도
    * 지역 클래스의 인스턴스가 소멸된 지역변수를
    * 참조하려는 경우가 발생할 수 있기 떄문
    *
    * */
public class Ex7_29
{
    public static void main(String[] args)
    {
        int VALUE = 10; // 외부 클래스의 지역변수
        Thread t = new Thread(new Runnable() { // ( ) 익명 클래스 내부 클래스
            public void run() {
                int test = 100;
                for(int i=0; i < 10;i++) { // 10 . 번 반복한다
                    try {
                        Thread.sleep(1*1000); // 1 . 초간 멈춘다
                    } catch(InterruptedException e) {}
                    System.out.println(VALUE); // 외부 클래스의 지역변수를 사용
                }
            } // run()
        });
        t.start(); // . 쓰레드를 시작한다
        System.out.println("main() - .");
    } // main
}
