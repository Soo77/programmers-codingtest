package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽부수고 이동하기
public class n2206_2 {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		if(N-1 == 0 && M-1 == 0) {
			System.out.print(1);
			System.exit(0);
		}

		int dx[] = {0,0,-1,1};
		int dy[] = {1,-1,0,0};

		char[][] map = new char[N][M];
		int[][] dist = new int[N][M]; //거리측정
		boolean[][][] visit = new boolean[2][N][M]; //벽을 부순 여부
		Queue<int[]> q = new LinkedList<>();

		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		q.offer(new int[]{0,0,0}); // 시작점 세팅(x,y, 부순 여부(0: 안부숨, 1:부숨))

		while(!q.isEmpty()) {
			int[] poll = q.poll();

			for(int i=0; i<4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];

				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

				// 다음칸에 벽이있을때
				if(map[nx][ny] == '1') {
					if(poll[2] == 0 && !visit[1][nx][ny]) {
						visit[poll[2]][nx][ny] = true; //(crash여부가 0인 배열)
						dist[nx][ny] = dist[poll[0]][poll[1]] + 1; // 현재 + 1
						q.offer(new int[]{nx,ny,1}); // 부쉈기때문에 1을 넣음.
					}
				} else { // 다음칸이 벽이 아닐때
					if(!visit[poll[2]][nx][ny]) {
						// 방문안했을때
						visit[poll[2]][nx][ny] = true;
						dist[nx][ny] = dist[poll[0]][poll[1]] + 1;
						q.offer(new int[]{nx, ny, poll[2]}); // 세번째거는 부쉈는지 안부쉈는지 넣어줌
					}
				}

				if(nx == N-1 && ny == M-1)  {
					System.out.print(dist[nx][ny] + 1);
					System.exit(0);
				}
			}

		}

		System.out.print(-1);




	}
}