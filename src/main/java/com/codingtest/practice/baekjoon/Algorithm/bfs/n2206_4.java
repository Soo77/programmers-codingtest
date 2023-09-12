package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽부수고 이동하기
public class n2206_4 {

	static int N,M;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		if (N - 1 == 0 && M - 1 == 0) {
			System.out.print(1);
			System.exit(0);
		}


		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				int num = s.charAt(j) - '0';
				map[i][j] = num;
			}
		}

		System.out.println(bfs());

	}
	private static int bfs() {

		int[][][] dist = new int[2][N][M];

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0,0,0});
		dist[0][0][0] = 1;

		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};

		while(true) {
			int[] poll = q.poll();
			int crush = poll[0];
			int x = poll[1];
			int y = poll[2];

			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

				if(map[nx][ny] == 0) { // 다음목적지가 벽이 아닐때
					if(dist[crush][nx][ny] == 0) { // 거리체크 배열 값이 비어있다면 (방문한적 없다면)
						q.add(new int[]{crush,nx,ny});
						dist[crush][nx][ny] = dist[crush][x][y] + 1;
						if(nx == N-1 && ny == M-1) {
							return dist[crush][nx][ny];
						}
					}
				} else { // 다음목적지가 벽일때
					if(crush == 0 && dist[1][nx][ny] == 0) {
						q.add(new int[]{1,nx,ny});
						dist[1][nx][ny] = dist[0][x][y] + 1;
						if(nx == N-1 && ny == M-1) {
							return dist[1][nx][ny];
						}
					}

				}
			}

			if(q.isEmpty()) {
				return -1;
			}
		}



	}
}