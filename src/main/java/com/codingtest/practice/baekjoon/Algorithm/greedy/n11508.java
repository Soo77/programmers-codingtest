package com.codingtest.practice.baekjoon.Algorithm.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n11508 {
    public static void main(String[] args) throws IOException {


        int N = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int[] time = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);


        int sum = time[0];
        int total = sum;
        for(int i=1; i<N; i++) {
            sum += time[i];
            total += sum;
        }

        bw.write(String.valueOf(total));
        bw.flush();


    }
}
