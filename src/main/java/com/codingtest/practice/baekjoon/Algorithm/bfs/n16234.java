package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n16234 {

	static int N,L,R;
	static int unite[][];
	static boolean visited[][];
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {1, -1, 0, 0};

	static int result = 0;

	static ArrayList<int[]> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		unite = new int[N][N];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				unite[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(unite[i][j]+",");
			}
			System.out.println();
		}


		System.out.println(move());
	}

	private static int move() {
		result = 0; // 걸린 일수
		while(true) {
			visited = new boolean[N][N];
			boolean isMove = false;

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						int sum = bfs(i, j);
						if(list.size() > 1) {
							changePopulation(sum);
							isMove = true;
						}
					}
				}
			}
			if(!isMove) {
				return result;
			}
			result++;
		}

	}

	private static void changePopulation(int sum) {
		int avg = sum / list.size();
		for(int i=0; i<list.size(); i++) {
			int x = list.get(i)[0];
			int y = list.get(i)[1];
			unite[x][y] = avg;
		}
	}

	private static int bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		list = new ArrayList<>();

		que.add(new int[]{x,y});
		list.add(new int[]{x,y});
		visited[x][y] = true;
		int sum = unite[x][y];

		while(!que.isEmpty()) {
			int[] poll = que.poll();

			for(int i=0; i<4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];

				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if(!visited[nx][ny]) {
						int diff = Math.abs(unite[nx][ny] - unite[poll[0]][poll[1]]);
						if(diff >= L && diff <= R) {
							visited[nx][ny] = true;
							que.add(new int[]{nx,ny});
							list.add(new int[]{nx,ny});
							sum += unite[nx][ny];
						}
					}
				}

			}
			System.out.println("\n"+result+"일차...");
			for(int t=0; t<N; t++) {
				for(int u=0; u<N; u++) {
					System.out.print(unite[t][u]+",");
				}
				System.out.println();
			}
		}
		return sum;
	}
}