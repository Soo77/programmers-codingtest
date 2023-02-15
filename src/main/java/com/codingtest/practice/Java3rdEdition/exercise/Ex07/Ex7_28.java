package com.codingtest.practice.Java3rdEdition.exercise.Ex07;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
* 7-29
* 지역 클래스에서 외부클래스의 인스턴스 멤버와 static멤버에
* 모두 접근할 수 있지만, 지역변수는 final이 붙은 상수만
* 접근할 수 있는 이유?
* >> 메서드가 수행을 마쳐서 지역변수가 소멸된 시점에도,
* 지역 클래스의 인스턴스가 소멸된 지역변수를 참조하려는 경우가
* 발생할 수 있기 때문.
*
*
* */
class Ex7_28
{
    public static void main(String[] args)
    {
        Frame f = new Frame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                e.getWindow().dispose();
                System.exit(0);
            }
        });
    }
}
