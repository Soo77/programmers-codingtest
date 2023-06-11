package com.codingtest.practice.baekjoon.Algorithm.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n13305_2 {
    public static void main(String[] args) throws IOException {


        int N = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        long[] dist = new long[N - 1];
        long[] cost = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(Arrays.toString(dist));
        System.out.println(Arrays.toString(cost));

        /*
         *  현재 주유소가 이전 주유소의 기름값보다 쌀 경우
         *  minCost를 갱신해준다.
         */

        long sum = 0;
        long minCost = cost[0];
        for(int i=0; i<dist.length; i++) {

            //System.out.println(cost[i]+","+minCost);
            if(cost[i] < minCost) {
                minCost = cost[i];
            }

            sum += minCost * dist[i];
        }


        bw.write(String.valueOf(sum));
        bw.flush();


    }
}
