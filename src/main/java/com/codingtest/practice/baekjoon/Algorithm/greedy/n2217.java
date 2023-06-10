package com.codingtest.practice.baekjoon.Algorithm.greedy;

import java.io.*;
import java.util.Arrays;

public class n2217 {
    public static void main(String[] args) throws IOException {
        int ropeCnt = 0;


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ropeCnt = Integer.parseInt(bf.readLine());
        int[] weight = new int[ropeCnt];
        for(int i=0; i<ropeCnt; i++) {
            weight[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(weight);

        int max = 0;
        int count = 1;
        for(int i=(weight.length - 1); i>=0; i--) {
            //System.out.print(weight[i]+", ");
            int w = weight[i] * count;
            //System.out.println("w:"+w+ ", max:"+max);
            count++;
            if(w > max) {
                max = w;
            }
        }

        //System.out.println(Arrays.toString(weight));


        bw.write(String.valueOf(max));
        bw.flush();


    }
}
