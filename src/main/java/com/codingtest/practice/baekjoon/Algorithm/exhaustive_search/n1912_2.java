package com.codingtest.practice.baekjoon.Algorithm.exhaustive_search;

import java.io.*;
import java.util.StringTokenizer;

public class n1912_2 {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N];

		int max = 0;
		int sum = 0;
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());

			if(i==0) max = num[0];
			sum += num[i];
			max = Math.max(max, sum);
			if(sum < 0) sum = 0;
		}

		bw.write(max+"");
		bw.flush();
	}

}

