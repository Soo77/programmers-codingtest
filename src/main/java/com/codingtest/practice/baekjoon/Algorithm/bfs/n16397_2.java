package com.codingtest.practice.baekjoon.Algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n16397_2 {

	static int N,T,G;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		
		int res = bfs();
		if(res == -1) System.out.println("ANG");
		else System.out.println(res);

	}

	private static int bfs() {
		boolean chk[] = new boolean[100000];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{N,0});
		chk[N] = true;

		while(!q.isEmpty()) {
			int num[] = q.poll();

			int n = num[0];
			int t = num[1];

			if(t > T) return -1;
			if(n == G) return t;

			int tmp = num[0] + 1;
			if(tmp < 100000 && !chk[tmp]) {
				chk[tmp] = true;
				q.offer(new int[]{tmp, t+1});
				System.out.println("A");
			}

			tmp = num[0] * 2;
			if(tmp > 99999) continue;
			String st = Integer.toString(tmp);
			System.out.println("전 tmp:"+tmp+", (int)Math.pow(10, st.length() - 1 :" +(int)Math.pow(10, st.length() - 1));
			tmp -= (int)Math.pow(10, st.length() - 1);
			System.out.println("후 tmp:"+tmp);
			if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
				chk[tmp] = true;
				q.offer(new int[] {tmp, t+1});
				System.out.println("B");
			}

			System.out.println("@@@@@@@@@@@@t:"+t);
		}
		return -1;
	}


}

