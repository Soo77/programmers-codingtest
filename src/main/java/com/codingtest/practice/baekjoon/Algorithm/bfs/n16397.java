package com.codingtest.practice.baekjoon.Algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n16397 {

	static int N,T,G;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());

		bfs();
	}

	private static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		boolean[] visited = new boolean[100000];
		visited[N] = true;
		q.add(new Pair(N, 0));

		while(!q.isEmpty()) {
			Pair temp = q.poll();
			if(temp.t > T) break;
			if(temp.n == G) {
				System.out.println(temp.t);
				return;
			}

			for(int i=0; i<2; i++) {
				if(i==0) {
					int nx = temp.n+1;
					if(nx>99999 || visited[nx]) continue;
					visited[nx] = true;
					q.add(new Pair(nx, temp.t+1));
				}
				else {
					int nx = temp.n*2;
					if(nx>99999 || nx == 0) continue;

					int idx = -1;

					for(int j=1; j<7; j++) {
						System.out.println("nx:"+nx+", nx%(int)Math.pow(10,j):"+nx%(int)Math.pow(10,j));

						if(nx%(int)Math.pow(10,j)==nx) {
							idx = j;
							break;
						}
					}

					if(idx != -1) {
						nx -= (int)Math.pow(10, idx-1);
						if(visited[nx]) continue;
						visited[nx] = true;
						q.add(new Pair(nx, temp.t+1));
					}
				}
			}
		}

		System.out.println("ANG");
	}

	public static class Pair {
		int n;
		int t;

		public Pair(int n, int t) {
			this.n = n;
			this.t = t;
		}
	}


}

