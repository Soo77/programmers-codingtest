package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽부수고 이동하기
public class n2206 {

	static int N,M;
	static int map[][];
	static boolean visited[][];
	static boolean isBreak = false;
	static boolean exitFlag = false;

	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static int count = 0;

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

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && !isBreak) {
					bfs(i, j);
					System.out.println("count:"+count);
				}
			}
		}
		
		
	}

	private static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[]{x,y});
		visited[x][y] = true;

		while(!que.isEmpty()) {
			int poll[] = que.poll();
			for(int i=0; i<4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];

				if(nx < 0 || ny < 0 || nx >= N || ny >=M) continue;;

				if(visited[nx][ny]) continue;

				if(map[nx][ny] == 1 && !isBreak) {
					map[nx][ny] = 0;
					isBreak = true;
				} else if(map[nx][ny] == 1 && isBreak) {
					return;
				}

				if(map[nx][ny] == 0) {
					que.add(new int[]{nx,ny});
					visited[nx][ny] = true;
					count++;
				}


			}
		}

	}
}