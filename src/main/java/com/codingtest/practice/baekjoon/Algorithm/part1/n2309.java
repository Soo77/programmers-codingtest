package com.codingtest.practice.baekjoon.Algorithm.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class n2309 {

    // 일곱난쟁이

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int peopleCnt = 0;
        List<Integer> cntList = new ArrayList<>();
        for(int i=0 ;i<10; i++) {
           String input = br.readLine();
           int out = Integer.parseInt(input.split(" ")[0])*(-1);
           int in = Integer.parseInt(input.split(" ")[1]);

           peopleCnt += (out+in);
           cntList.add(peopleCnt);
        }

        int max = Collections.max(cntList);

        bw.write(String.valueOf(max));
        bw.flush();
    }
}
