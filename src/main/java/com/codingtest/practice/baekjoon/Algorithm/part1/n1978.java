package com.codingtest.practice.baekjoon.Algorithm.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n1978 {

    // 소수 찾기

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int num = Integer.parseInt(br.readLine());
        int count = num;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<num; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n==1)
                count--;
            for(int j=2; j<=Math.sqrt(n); j++) {
                if(n%j==0) {
                    count--;
                    break;
                }
            }

        }
        bw.write(count+"");

        bw.flush();

    }
}
