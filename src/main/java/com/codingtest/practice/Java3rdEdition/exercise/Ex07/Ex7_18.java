package com.codingtest.practice.Java3rdEdition.exercise.Ex07;

import java.util.Arrays;

/*
* 7-20
* p.x = 100
* ChildMethod ㅜㅜ
* c.x = 200
* ChildMethod
* */
public class Ex7_18 {

    private static void action(Robot r) {
        if(r instanceof DanceRobot) {
            DanceRobot dr = (DanceRobot)r;
            dr.dance();
        } else if(r instanceof SingRobot) {
            SingRobot sr = (SingRobot)r;
            sr.sing();
        } else if(r instanceof DrawRobot) {
            DrawRobot dr = (DrawRobot)r;
            dr.draw();
        }
    }


    public static void main(String[] args) {
        /*Robot[] arr = {new DanceRobot(), new SingRobot(), new DrawRobot()};

        for(int i=0; i<arr.length; i++) {
            action(arr[i]);
        }*/
        int num, result;
        final int ONE = 1;

        int[] cart = {1,2,3};

        int[] cart2 = new int[cart.length*2];
        System.arraycopy(cart,0,cart2,0,cart.length);
        cart = cart2;

        System.out.println(Arrays.toString(cart));
        System.out.println(Arrays.toString(cart2));
    }


}

class Robot{}

class DanceRobot extends Robot {
    void dance() {
        System.out.println("춤을 춥니다.");
    }
}

class SingRobot extends Robot {
    void sing() {
        System.out.println("노래를 합니다.");
    }
}

class DrawRobot extends Robot {
    void draw() {
        System.out.println("그림을 그립니다.");
    }
}