package com.codingtest.practice.baekjoon.Algorithm.random;

import java.io.*;

public class n2193 {



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N= Integer.parseInt(br.readLine());
		long d[] = new long[N+1];

		d[0] = 0;
		d[1] = 1;

		for(int i=2; i<=N; i++) {
			d[i] = d[i-1] + d[i-2];
		}

		System.out.println(d[N]);

	}


}