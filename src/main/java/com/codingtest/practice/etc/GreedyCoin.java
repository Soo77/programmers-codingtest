package com.codingtest.practice.etc;

import java.util.ArrayList;
import java.util.List;

//그리디 알고리즘 예시
public class GreedyCoin {

    public static void main(String[] args) {

        int n = 1260;
        int cnt=0;

        int coinTypes[] = {500, 100, 50, 10};

        for(int i=0; i<coinTypes.length; i++) {
            cnt += n / coinTypes[i];
            n %= coinTypes[i];
        }
        System.out.println(cnt);



    }
}
