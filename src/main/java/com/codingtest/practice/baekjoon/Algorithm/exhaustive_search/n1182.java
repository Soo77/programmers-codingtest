package com.codingtest.practice.baekjoon.Algorithm.exhaustive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1182 {


	static int N, target;
	static int count;
	static int[] arr;
	static int howmany;
	public static void dfs(int index, int sum){
		howmany++;
		System.out.println("index:"+index+",sum:"+sum);
		//System.out.println("index:"+index);
		if(index == N){
			System.out.println("N:"+index);
			if(sum == target){
				count++;
			}
			System.out.println("지금 sum은"+sum+"이고, 리턴한다.");
			return;
		}
		System.out.println("arr["+index+"]: "+arr[index]+", " + (sum)+"+"+arr[index]);
		System.out.println();
		dfs(index + 1, sum + arr[index]);
		System.out.println("hey sum:"+sum);
		dfs(index + 1, sum);
		//System.out.println();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken()); //S
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		System.out.println(target == 0 ? count - 1 : count);
		System.out.println("howmany:"+howmany);
	}
}