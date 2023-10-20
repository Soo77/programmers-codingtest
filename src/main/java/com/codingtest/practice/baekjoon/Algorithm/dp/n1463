package com.codingtest.practice.baekjoon.Algorithm.dp;

import java.io.*;
import java.util.*;

public class n1463 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int x = Integer.parseInt(br.readLine());
 		int dp[] = new int[x+1];
 		for(int i=2; i<=x; i++) {
			int min = dp[i-1] + 1;
 			if(i%2==0) min = Math.min(min, dp[i/2]+1);
 			if(i%3==0) min = Math.min(min, dp[i/3]+1);
 			dp[i] = min;
		}
 		bw.write(dp[x]+"");
		bw.flush();
    }
}
