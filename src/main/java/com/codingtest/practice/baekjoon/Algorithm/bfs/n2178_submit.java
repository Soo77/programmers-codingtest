package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로탐색 //아직 작성중
public class n2178_submit {

    static int N,M;
    static int map[][];
    static boolean visited[][];
    static int count = 0;
    static int sum = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++) {
            String[] s = br.readLine().split("");
            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        bfs(1,1);

        System.out.println(map[N][M]);

    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> que = new LinkedList<>();

        visited[startX][startY] = true;
        que.add(new int[] {startX, startY});

        visited[startX][startY] = true;

        int[] X = {0, 0, -1, 1};
        int[] Y = {-1, 1, 0, 0};

        while(!que.isEmpty()) {
            int[] poll = que.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            for(int i=0; i<4; i++) {
                int x = poll[0] + X[i];
                int y = poll[1] + Y[i];

                if(x<=0 || x> N || y<=0 || y>M) {
                    continue;
                }

                if(map[x][y] == 1 && !visited[x][y]) {
                    que.add(new int[] {x, y});
                    map[x][y] = map[nowX][nowY] + 1;
                    visited[x][y] = true;
                }
            }
        }
    }
}
