package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n7576_2 {

	static int M,N;
	static int tomato[][];
	static boolean visited[][];
	static int time[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};

    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tomato = new int[N][M];
		time = new int[N][M];
		visited= new boolean[N][M];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print("("+i+","+j+"),");
			}
			System.out.println();
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && tomato[i][j] == 1) {
					bfs(i,j);
				}
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(time[i][j] + ",");
			}
			System.out.println();
		}




	}

	private static void bfs(int startX, int startY) {
		Queue<int[]> que = new LinkedList<>();
		visited = new boolean[N][M];
		que.add(new int[]{startX,startY});
		visited[startX][startY] = true;

		while(!que.isEmpty()) {
			int poll[] = que.poll();
			int nowX = poll[0], nowY = poll[1];
			int nextX = 0, nextY = 0;
			for(int i=0; i<4; i++) {
				nextX = poll[0] + dx[i];
				nextY = poll[1] + dy[i];

				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

				if(tomato[nextX][nextY] == 0) tomato[nextX][nextY] = 1;

				//System.out.println(visited[nextX][nextY]+"가 false 고 "+);

				System.out.println("visitied 모양새");
				for(int j=0; j<N; j++) {
					for(int k=0; k<M; k++) {
						System.out.print(visited[i][j] + ",");
					}
					System.out.println();
				}


				if(!visited[nextX][nextY] && tomato[nextX][nextY] == 1) {
					System.out.println("들어온 nextX, nextY ("+nextX+","+nextY+")");
					que.add(new int[]{nextX, nextY});
					bfs(nextX, nextY);
					time[nextX][nextY] = time[nowX][nowY] + 1;
					visited[nextX][nextY] = true;
				}
			}
		}




=======
import java.io.*;
import java.util.*;

public class n7576 {


	static int N,M;
	static int box[][];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
 		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
 		box = new int[N][M];
 		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			 for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			 }
		}
 		int result = bfs();
		System.out.println(result);
 	}
 	private static int bfs() {
		Queue<Tomato> que = new LinkedList<>();
		int day = 0;
 		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 1) {
					que.offer(new Tomato(i,j,0));
				}
			}
		}
 		while(!que.isEmpty()) {
			Tomato tomato = que.poll();
			day = tomato.day;
 			for(int i=0; i<4; i++) {
				int nx = tomato.x + dx[i];
				int ny = tomato.y + dy[i];
 				if(nx >= 0 && ny >= 0 && nx < N && ny <M ) {
					if(box[nx][ny] == 0) {
						box[nx][ny] = 1;
						que.add(new Tomato(nx,ny,day+1));
					}
				}
			}
		}
 		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 0) return -1;
			}
		}
 		return day;
	}
 	static class Tomato {
		int x;
		int y;
		int day;
 		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
>>>>>>> 4db1f3ad8cab999aba9219b1ca5548b2b510284d
	}
}
