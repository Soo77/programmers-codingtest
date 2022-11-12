package com.codingtest.practice.baekjoon.Algorithm.part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n14888_3 {

    // 연산자 끼워넣기
    // 다시풀어보기

    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] operator = new int[4];
    static int[] number;

    static void dfs(int num, int idx) {
        if(idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for(int i=0; i<4; i++) {
            if(operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0 : dfs(num + number[idx], idx+1); break;
                    case 1 : dfs(num - number[idx], idx+1); break;
                    case 2 : dfs(num * number[idx], idx+1); break;
                    case 3 : dfs(num / number[idx], idx+1); break;
                }
                operator[i]++;
            }
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4 ;i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(number[0], 1);

        System.out.println(max +","+ min);


    }
}
