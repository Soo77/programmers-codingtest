package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.*;

public class n1012 {

    static int N,M,K;
    static boolean visited[][];
    static int cabbage[][];
    static int worm;

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int x = 0, y = 0;
        for(int i=0; i<T; i++) {  // 총 몇개의 배추밭이 있는지
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cabbage = new int[N][M];
            visited = new boolean[N][M];
            worm = 0;
            for(int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                cabbage[x][y] = 1;
            } // 배추심기 끝

            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(cabbage[j][k] == 1 && !visited[j][k]) {
                        dfs(j,k);
                        worm ++;
                    }
                }
            }

            bw.write(worm + "\n");
        }
        bw.flush();
    }

    private static void dfs(int startX, int startY) {
        visited[startX][startY] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int k=0; k<4; k++) {
            int x = startX + dx[k];
            int y = startY + dy[k];

            if(x < 0 || x >= N || y < 0 || y >= M) {
                continue;
            }

            if(cabbage[x][y] == 1 && !visited[x][y]) {
                dfs(x,y);
            }
        }

    }


}
