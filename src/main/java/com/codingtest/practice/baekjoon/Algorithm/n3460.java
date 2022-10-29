package com.codingtest.practice.baekjoon.Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class n3460 {

    // 이진수

    public static void main(String[] args) throws Exception {

        //양의 정수 n이 주어졌을 때, 이를 이진수로 나타냈을 때 1의 위치를 모두 찾는 프로그램을 작성하시오.
        // 최하위 비트(least significant bit, lsb)의 위치는 0이다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int cnt = Integer.parseInt(br.readLine());

        for(int i=0; i<cnt; i++) {
            int decimal = Integer.parseInt(br.readLine());
            String binary = Integer.toString(decimal,2);
            int bLen = binary.length();
            for(int j=bLen-1; j>=0; j--) {
                if(binary.charAt(j)=='1') {
                    bw.write(String.valueOf(bLen-j-1+" "));
                }
            }
            bw.flush();
        }






    }
}
