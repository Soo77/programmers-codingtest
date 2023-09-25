package com.codingtest.practice.baekjoon.Algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n9019 {

	static int A,T, B;
	static String ans[] = new String[4];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int res = bfs();
		if(res == -1) System.out.println("ANG");
		else System.out.println(res);

		/*String s  = "0001";
		int num = Integer.parseInt(s);
		System.out.println("num:"+num);*/

		for(int i=0; i<4; i++) {
			System.out.println(ans[i] + ",");
		}

	}

	private static int bfs() {
		boolean chk[] = new boolean[100000];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{A,0});
		chk[A] = true;

		while(!q.isEmpty()) {
			int num[] = q.poll();

			int n = num[0];
			int t = num[1];

			if(n == B) return t;

			// D
			int tmp = n*2;
			if(tmp > 9999) {
				tmp %= 100000;
			}

			if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
				chk[tmp] = true;
				q.offer(new int[] {tmp, t+1});
				ans[0] += "D";
			}

			// S
			tmp = n - 1;
			if( n == 0) {
				tmp = 9999;
			}
			if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
				chk[tmp] = true;
				q.offer(new int[] {tmp, t+1});
				ans[1] = "S";
			}

			//L
			tmp = n;
			String s = String.valueOf(tmp);
			String s2 = "";
			if(s.length() > 1) {
				for(int i=1; i<s.length(); i++) {
					s2 += s.charAt(i) - '0';
				}
				s2 += s.charAt(0) - '0';
			}
			if(s2 == "") {
				tmp = 0;
			} else {
				tmp = Integer.parseInt(s2);
			}
			if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
				chk[tmp] = true;
				q.offer(new int[] {tmp, t+1});
				ans[2] += "L";
			}

			//R
			tmp = n;
			s = String.valueOf(tmp);
			s2 = "";
			s2 += s.charAt(s.length() - 1) - '0';
			for(int i=0; i<s.length() - 1; i++) {
				s2 += s.charAt(i) - '0';
			}
			if(s2 == "") {
				tmp = 0;
			} else {
				tmp = Integer.parseInt(s2);
			}
			if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
				chk[tmp] = true;
				q.offer(new int[] {tmp, t+1});
				ans[3] += "R";
			}
		}
		return -1;
	}


}

