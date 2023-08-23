package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.*;

public class n6593 {

	static int L,R,C;
	static char[][][] map;
	static StringBuilder sb = new StringBuilder();
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L == 0 && R == 0 && C == 0) {
				System.out.println(sb.toString());
				return;
			}
			
			int sx = 0, sy = 0, sz = 0;
			map = new char[L][R][C];
			for(int i=0; i<L; i++) {
				for(int j=0; j<R; j++) {
					String line = br.readLine();
					for(int k=0; k<C; k++) {
						map[i][j][k] = line.charAt(k);
						if(map[i][j][k] == 'S') {
							sx = k; sy = j; sz = i;
							map[i][j][k] = '.';
						}
					}
				}
				br.readLine();
			}
			bfs(sx,sy,sz);
		}
	}
	
	private static void bfs(int x, int y, int z) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] check = new boolean[L][R][C];
		q.add(new int[]{x,y,z,0});
		check[z][y][x] = true;
		
		while(!q.isEmpty()) {
			int p[] = q.poll();
			int px = p[0], py = p[1], pz = p[2];
			int move = p[3];
			
			if(map[pz][py][px] == 'E' ) {
				sb.append("Escaped in "+move+" minute(s).\n");
				return;
			}
			
			for(int d=0; d<6; d++) {
				int nx = px + dx[d];
				int ny = py + dy[d];
				int nz = pz + dz[d];
				if(nx < 0 || ny < 0 || nz < 0 || nx >= C || ny >= R || nz >= L) {
					continue;
				}
				
				if(check[nz][ny][nx]) continue;
				
				if(map[nz][ny][nx] == '.' || map[nz][ny][nx] == 'E') {
					check[nz][ny][nx] = true;
					q.add(new int[]{nx, ny, nz, move+1});
				}
			}
		}
		sb.append("Trapped!\n");
	}
}