package com.codingtest.practice.baekjoon.Algorithm.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class n11399 {
    public static void main(String[] args) throws IOException {


        int N = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int[] product = new int[N];

        for(int i=0; i<N; i++) {
            product[i] = Integer.parseInt(br.readLine());
        }

        Integer[] tempArr = Arrays.stream(product).boxed().toArray(Integer[]::new);
        Arrays.sort(tempArr, Collections.reverseOrder());

        //System.out.println(Arrays.toString(tempArr));

        long sum = 0;
        for(int i=0; i<N; i++) {
            if((i+1)%3 != 0) {
                //System.out.println(tempArr[i]);
                sum += tempArr[i];
            }
        }




        bw.write(String.valueOf(sum));
        bw.flush();


    }
}
