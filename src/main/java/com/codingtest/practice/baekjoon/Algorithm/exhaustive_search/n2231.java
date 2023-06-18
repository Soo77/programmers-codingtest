package com.codingtest.practice.baekjoon.Algorithm.exhaustive_search;

import java.io.*;

public class n2231 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int sum = 0, result = 0;
        int NLen = (int)(Math.log10(N)+1);

        int startVal = N-(NLen * 9);
        for(int i=startVal; i<=N; i++) {
            int num = i;
            while(num>0) {
                sum += num%10;
                num/=10;
            }

            sum += i;
            if(sum == N) {
                result = i;
                break;
            }

            sum = 0;
        }





        bw.write(String.valueOf(result));
        bw.flush();


    }
}
