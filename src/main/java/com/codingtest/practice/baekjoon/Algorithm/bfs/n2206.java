package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.StringTokenizer;

// 벽부수고 이동하기
public class n2206 {

	static int N,M;
	static int map[][];
	static boolean visited[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited  = new boolean[N][M];

		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s.split("")[j]);
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}