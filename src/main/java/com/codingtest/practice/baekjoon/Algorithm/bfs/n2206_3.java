package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽부수고 이동하기
public class n2206_3 {

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

		//방문을 체크하는 3차원 배열
		int[][][] dist = new int[2][N][M];
		//[0, n, m] : 벽 안부수고 지나가는 방문노드 경로
		//[1, n, m] : 벽 부수고 지나가는 방문노드 경로

		int dx[] = {0,0,-1,1};
		int dy[] = {1,-1,0,0};

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{0,0,0});
		dist[0][0][0] = 1;

		while(true) {
			int[] node = q.poll();
			int breakYN = node[0]; // 벽을 부쉈거나 안부쉈거나
			int x = node[1];
			int y = node[2];

			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

				// 다음 목적지가 벽이 아닐때
				// 거리체크 dist 배열이 비어있다면 breakYN 0, 1 일때를 따로 체크
				if(map[nx][ny] == 0) {
					if(dist[breakYN][nx][ny] == 0) {
						q.offer(new int[] {breakYN, nx, ny});
						dist[breakYN][nx][ny] = dist[breakYN][x][y] + 1;
						if(nx == N-1 && ny == M-1) {
							return dist[breakYN][nx][ny];
						}

					}
				} else { // 다음 노드가 벽일때
					if(breakYN == 0 && dist[1][nx][ny] == 0) { // 부순적 없을때 && 다음칸을 방문한적 있는지
						q.offer(new int[]{1, nx, ny});
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