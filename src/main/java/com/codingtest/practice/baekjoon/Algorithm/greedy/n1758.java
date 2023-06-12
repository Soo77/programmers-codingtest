package com.codingtest.practice.baekjoon.Algorithm.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class n1758 {
    public static void main(String[] args) throws IOException {


        int N = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int[] tipArr = new int[N];

        for(int i=0; i<N; i++) {
            tipArr[i] = Integer.parseInt(br.readLine());
        }

        Integer[] tempArr = Arrays.stream(tipArr).boxed().toArray(Integer[]::new);
        Arrays.sort(tempArr, Collections.reverseOrder());

        //System.out.println(Arrays.toString(tempArr));

        long sum = 0;
        for(int i=0; i<N; i++) {
            int tip = tempArr[i] - i;
            if(tip > 0) {
                sum += tip;
            }

        }


        bw.write(String.valueOf(sum));
        bw.flush();


    }
}
