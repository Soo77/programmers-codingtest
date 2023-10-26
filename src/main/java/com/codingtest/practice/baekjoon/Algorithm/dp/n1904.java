package com.codingtest.practice.baekjoon.Algorithm.dp;

import java.io.*;

public class n1904 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int N = Integer.parseInt(br.readLine());
 		int dp[] = new int[N+1];
        dp[0] = 1;
		dp[1] = 2;
 		for(int i=2; i<=N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		}
 		bw.write(dp[N-1]+"");
		bw.flush();
    }
}
