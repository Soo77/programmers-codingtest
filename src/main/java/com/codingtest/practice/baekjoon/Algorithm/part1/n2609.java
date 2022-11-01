package com.codingtest.practice.baekjoon.Algorithm.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n2609 {

    // 최소공배수 최대공약수 구하기


    static int gdc(int a, int b) {
        if(a<b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while(b!=0) {
            int r = a%b;
            a = b;
            b = r;

        }
        return a;
    }
    static int lcm(int a, int b) {
        return a*b/gdc(a,b);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(gdc(a,b) + "\n");
        bw.write(String.valueOf(lcm(a,b)));
        bw.flush();

    }
}
