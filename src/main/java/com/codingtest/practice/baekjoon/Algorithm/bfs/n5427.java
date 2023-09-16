package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽부수고 이동하기
public class n5427 {

	static int N,M,ans;
	static char[][] map;
	static Queue<int[]> q;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();


		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			ans = 0;
			q = new LinkedList<>();

			int x=0,y=0;
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '*') {
						q.add(new int[]{i,j});
					} else if(map[i][j] == '@') {
						x=i;
						y=j;
					}
					// 여기 아니고 q.add(new int[]{x,y});
				}
			}
			q.add(new int[]{x,y});//여기임
			sb.append(simulation() ? ans : "IMPOSSIBLE").append("\n");


		}


		System.out.println(sb);

	}

	private static boolean simulation() {
		while(!q.isEmpty()) {
			ans++;
			for(int i=0, size=q.size(); i<size; i++) { //하핫 size저장
				int poll[] = q.poll();
				int x = poll[0];
				int y = poll[1];
				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];

					if(nx<0 || nx>=N || ny<0 || ny>=M) {
						if(map[x][y] == '@') {
							//q.add(new int[]{x,y});
							return true;
						}
						continue;
					}

					if(map[nx][ny] != '.') {
						continue;
					}

					q.add(new int[]{nx,ny});
					map[nx][ny] = map[x][y];

				}
			}
		}
		return false;
	}
}