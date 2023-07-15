package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.StringTokenizer;

public class n1012_2 {

    static int N, M, K;
    static int map[][];
    static boolean visited[][];

    static int count = 0;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        for(int i=0; i<T; i++) { //테스트 케이스 도는중
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                //System.out.println(x+","+y);
                map[x][y] = 1;
            }

            count = 0;
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {

                    if(map[j][k] == 1 && !visited[j][k]) {
                        dfs(j,k);
                        count++;
                    }
                }
            }
            //System.out.println(count);

            bw.write(count+"\n");
        }
        bw.flush();
    }

    private static void dfs(int startX, int startY) {
        visited[startX][startY] = true;

        for(int i=0; i<4; i++) {
            int x = dx[i] + startX;
            int y = dy[i] + startY;

            if(x<0 || x>=N || y<0 || y>=M) {
                continue;
            }

            if(map[x][y]==1 && !visited[x][y]) {
                dfs(x,y);
            }
        }
    }
}