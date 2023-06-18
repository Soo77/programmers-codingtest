package com.codingtest.practice.baekjoon.Algorithm.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n20300 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] loss = new long[N];

        for(int i=0; i<N; i++) {
            loss[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(loss);

        //System.out.println(Arrays.toString(loss));

        long minVal = loss[N-1];
        if(N%2==1) {
            minVal = loss[N-1];
            for(int i=0; i<N/2; i++) {
                long n = loss[i] + loss[N-i-2];
                //System.out.println(loss[i] + "," + loss[N-i-2]);
                if(n > minVal) minVal = n;
            }
        } else {
            for(int i=0; i<N/2; i++) {
                long n = loss[i] + loss[N-i-1];
                //System.out.println(loss[i] + "," + loss[N-i-1]);
                if(n > minVal) minVal = n;
            }
        }



        bw.write(String.valueOf(minVal));
        bw.flush();


    }
}
