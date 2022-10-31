package com.codingtest.practice.baekjoon.Algorithm.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class n10870 {

    // 피보나치 수 5

    static int fibo(int n) {
        if(n==0) return 0;
        else if(n==1) return 1;
        return fibo(n-1) + fibo(n-2);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int num = Integer.parseInt(br.readLine());
        String result = String.valueOf(fibo(num));

        bw.write(result);
        bw.flush();
    }
}
