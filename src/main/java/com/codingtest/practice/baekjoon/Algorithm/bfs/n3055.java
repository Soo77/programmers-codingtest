package com.codingtest.practice.baekjoon.Algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n3055 {

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

			// 물 이동동
		    for(int i = 0, w_len = wq.size(); i<w_len; i++) {
				int cur_w[] = wq.poll();
				int x = cur_w[0];
				int y = cur_w[1];
				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];

					if(nx >=0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {

						// 물의 새로운 좌표를 물로 채움
						map[nx][ny] = '*';

						// 물의 새로운 좌표를 물큐에 넣어줌
						wq.add(new int[]{nx,ny});
					}
				}
			}

			// 고슴도치 이동
			for(int i=0, s_len = sq.size(); i<s_len; i++) {
				int[] cur_s = sq.poll();
				int x = cur_s[0];
				int y = cur_s[1];
				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					int time = cur_s[2];

					// 고슴이의 새로운 좌표가 map 범위안에 있따면
					if(nx >= 0 && nx<R && ny >=0 && ny < C) {
						// 고심이의 새 좌표가 비버굴에 도착했으면 종료
						if(map[nx][ny] == 'D') {
							ans = Math.min(ans,time+1);
							return;
						}

						// 고심이 새 좌표가 갈 수 있는 공간이면
						else if(map[nx][ny] == '.') {
							map[nx][ny] = 'S';
							sq.add(new int[]{nx,ny,time+1});
						}
					}
				}
			}
		}
	}

       
}

