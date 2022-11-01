package com.codingtest.practice.baekjoon.Algorithm.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class n14888 {

    // 연산자 끼워넣기

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Integer> numList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }

        int[] operArr = new int[4];
        StringTokenizer oper = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            operArr[i] = Integer.parseInt(oper.nextToken());
        }

        for(int     )


        bw.flush();

    }
}
