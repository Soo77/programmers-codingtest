package com.codingtest.practice.baekjoon.Algorithm.exhaustive_search;
import java.io.*;
import java.util.StringTokenizer;

//DP
/*
* DP(다이나믹 프로그래밍)
* 하나의 큰 문제를 여러 개의 작은 문제로 나누어서 그 결과를
* 저장하여 다시 큰 문제를 해결할 때 사용
*
* DP가 적용되기 위해서는 2가지 조건을 만족해야함.
* 1) Overlapping Subproblems(겹치는 부분 문제)
* 2) Optimal Substructure(최적 부분 구조)
*
*
*
* */
public class n17484 {

	static int min = Integer.MAX_VALUE;
	static int fuel[][];
	static int[] ydir = {-1, 0, 1};
	static int[] visited;

	static int row, col;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        fuel = new int[row][col];
        for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
        	for(int j=0; j<col; j++) {
        		fuel[i][j] = Integer.parseInt(st.nextToken());
			}
		}

        for(int i=0; i<col; i++) {
			visited = new int[row];
			visited[0] = i;
			dfs(1, i, -1);
		}




		bw.write( min+"");
		bw.flush();
	}

	private static void dfs(int depth, int y, int dir) {
		if(depth == row) {
			int sum = fuel[0][visited[0]];
			for(int i=1; i<row; i++) {
				sum += fuel[i][visited[i]];
			}

			min = min > sum ? sum : min;
			return;
		}

		for(int i=0; i<3; i++) {
			int dy = y + ydir[i];
			if(isValidPosition(dy) && dir != i) {
				visited[depth] = dy;
				dfs(depth+1, dy, i);
			}
		}
	}

	private static boolean isValidPosition(int y) {
    	if(y<0 || y>=col)
    		return false;
    	return true;
	}


}

