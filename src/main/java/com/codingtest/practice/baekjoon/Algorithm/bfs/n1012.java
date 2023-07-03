package com.codingtest.practice.baekjoon.Algorithm.bfs;


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
                        bfs(j,k);
                        worm ++;
                    }
                }
            }

            bw.write(worm + "\n");
        }
        bw.flush();
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {startX, startY});
        // 저장

        visited[startX][startY] = true;

        int[] X = {0, 0, -1, 1};
        int[] Y = {-1, 1, 0, 0};

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            for(int i=0; i<4; i++) {
                int x = poll[0] + X[i];
                int y = poll[1] + Y[i];

                if(x<0 || x>= N || y<0 || y>=M) {
                    continue;
                }

                if(cabbage[x][y] == 1 && !visited[x][y]) {
                    queue.offer(new int[] {x, y});

                    visited[x][y] = true;
                }
            }
        }



    }


}
