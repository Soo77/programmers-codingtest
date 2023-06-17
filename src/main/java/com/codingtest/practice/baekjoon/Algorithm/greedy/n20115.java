package com.codingtest.practice.baekjoon.Algorithm.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n20115 {
    public static void main(String[] args) throws IOException {




        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] drink = new double[N];

        for(int i=0; i<N; i++) {
            drink[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(drink);

        double sum = drink[N-1];
        for(int i=N-2; i>=0; i--) {
            //System.out.println(sum+","+ (drink[i]/2));
            sum += drink[i]/2;
        }



        bw.write(String.valueOf(sum));
        bw.flush();


    }
}
