package com.codingtest.practice.etc;

import java.util.Arrays;

//이코테2021 따라하기
//그리디 알고리즘 예시
//시각 중에서 3 찾기
public class ClockThree {

    public static boolean check(int h, int m, int s) {

        if (h%10==3 || m/10==3 || m%10==3 || s/10==3 || s%10==3) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {

        int N = 5;

        int result = 0;

        for(int h=0; h<=N; h++) {
            for(int m=0; m<60; m++) {
                for(int s=0; s<60; s++) {
                    System.out.println(h+":"+m+":"+s);
                    if(check(h,m,s)) {
                        result++;
                    }
                }
            }
        }
        System.out.println("result:"+result);
    }
}
