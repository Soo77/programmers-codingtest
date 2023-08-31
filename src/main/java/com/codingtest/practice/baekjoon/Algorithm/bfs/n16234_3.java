package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n16234_3 {

	static int N,L,R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static boolean isMove;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;

		while(true) {
			visited = new boolean[N][N];
			isMove = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						bfs(i,j);
					}
				}
			}
			if(!isMove) {
				break;
			}
			count++;
		}

		System.out.println(count);

	}

	private static void bfs(int i, int j) {
		Queue<Node> moveArea = new LinkedList<>();
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(i,j));
		moveArea.add(new Node(i,j));

		visited[i][j] = true;
		int sum = 0;
		sum += map[i][j];

		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			queue.poll();
			for(int d=0; d<4; d++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny <0 || nx >=N || ny>=N) continue;

				if(visited[nx][ny]) continue;;

				int diff = Math.abs(map[x][y] - map[nx][ny]);

				if(diff >= L && diff <= R) {
					visited[nx][ny] = true;
					moveArea.add(new Node(nx,ny));
					queue.add(new Node(nx,ny));
					sum += map[nx][ny];
				}
			}
		}

		int avg = 0;
		if(moveArea.size() > 1) {
			avg = sum / moveArea.size();
			isMove = true;

			while(!moveArea.isEmpty()) {
				map[moveArea.peek().x][moveArea.peek().y] = avg;
				moveArea.poll();
			}
		}

	}

	static class Node {
		int x,y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}