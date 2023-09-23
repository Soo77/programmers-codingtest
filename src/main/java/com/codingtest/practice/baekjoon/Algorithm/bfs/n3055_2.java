package com.codingtest.practice.baekjoon.Algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n3055_2 {

	static int R,C;
	static char map[][];
	static Queue<int[]> sq = new LinkedList<>();
	static Queue<int[]> wq = new LinkedList<>();
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for(int i = 0; i< R; i++) {
			String s = br.readLine();
			for(int j = 0; j< C; j++) {
				map[i][j] = s.charAt(j);

				if(map[i][j] == 'S') {
					sq.add(new int[]{i,j,0});
				} else if(map[i][j] == '*') {
					wq.add(new int[]{i,j});
				}
			}
		}
		bfs();
		sb.append(ans == Integer.MAX_VALUE ? "KAKTUS" : ans);
		System.out.print(sb);
	}

	private static void bfs() {
		while(!sq.isEmpty()) {

			// 물 먼저 옮기기
			for(int i=0, w_len = wq.size(); i<w_len; i++) {
				int poll[] = wq.poll();
				int x = poll[0];
				int y = poll[1];

				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];

					if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {

						map[nx][ny]  = '*';
						wq.add(new int[]{nx,ny});
					}
				}
			}

			// 고심이 이동
			for(int i=0, s_len = sq.size(); i<s_len; i++) {
				int poll[] = sq.poll();
				int x = poll[0];
				int y = poll[1];

				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					int time = poll[2];

					if(nx >=0 && nx < R && ny >= 0 && ny < C) {
						if(map[nx][ny] == 'D') {
							ans = Math.min(ans, time+1);
							return;
						} else if(map[nx][ny] == '.') {
							map[nx][ny] = 'S';
							sq.add(new int[]{nx,ny,time+1});
						}
					}
				}
			}
		}


	}


}

