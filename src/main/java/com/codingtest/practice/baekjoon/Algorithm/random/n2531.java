package com.codingtest.practice.baekjoon.Algorithm.random;

import java.io.*;
import java.util.StringTokenizer;

public class n2531 {

	static int n, d, k, c;
	static int[] sushi;
	static int[] ate;



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 회전 초밥 접시의 수
		n = Integer.parseInt(st.nextToken());

		// 초밥 가짓수
		d = Integer.parseInt(st.nextToken());

		// 연속해서 먹는 접시의 수
		k = Integer.parseInt(st.nextToken());

		// 쿠폰 번호
		c = Integer.parseInt(st.nextToken());

		sushi = new int[n];
		ate = new int[d+1];

		for(int i=0; i<n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		// 0번부터 k개까지 먹었을 때 초기화
		int count = 0;
		for(int i=0; i<k; i++) {
			if(ate[i] == 0) count++;
			ate[sushi[i]]++;
		}

		int maxLen = count;
		for(int i=1; i<n; i++) {
			if(maxLen <= count) {
				if(ate[c] == 0) {
					maxLen = count+1;
				} else {
					maxLen = count;
				}
			}

			int end = (i+k-1)%n;
			if(ate[sushi[end]] == 0) {
				count++;
			}
			ate[sushi[end]]++;

			ate[sushi[i-1]]--;
			if(ate[sushi[i-1]]==0) {
				count--;
			}
		}
		System.out.println(maxLen);

	}


}