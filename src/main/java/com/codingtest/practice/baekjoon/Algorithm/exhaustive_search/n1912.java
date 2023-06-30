package com.codingtest.practice.baekjoon.Algorithm.exhaustive_search;

import java.io.*;
import java.util.*;

public class n1912 {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N];

		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int max = num[0];
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += num[i];
			//System.out.println("num["+i+"]:"+num[i]+",sum:"+sum);
			max = Math.max(max, sum);
			//System.out.println("max:"+max);
			if(sum < 0) sum = 0;
		}


		bw.write(max+"");
		bw.flush();
	}

}

