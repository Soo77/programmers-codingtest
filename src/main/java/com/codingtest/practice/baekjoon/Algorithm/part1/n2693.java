package com.codingtest.practice.baekjoon.Algorithm.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class n2693 {

    // N번째 큰수



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> numList = new ArrayList<>();
            for(int j=0; j<10; j++) {
                numList.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(numList);
            bw.write(numList.get(numList.size()-3)+"\n");
        }
        bw.flush();

    }
}
