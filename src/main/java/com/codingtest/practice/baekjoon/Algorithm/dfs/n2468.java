package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.StringTokenizer;

public class n2468 {

    //안전영역

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;

    /*private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};*/
    private static int[] dx = {0, 1, 0, -1}; //상우하좌
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        int max = 0;
        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }


        int answer = 0;
        for(int i=1; i<=max; i++) {
            int cnt = 0;
            visited = new boolean[N+1][N+1];
            for(int j=1; j<N+1; j++) {
                for(int k=1; k<N+1; k++) {
                    if(!visited[j][k] && map[j][k] >= i) {
                        cnt++;
                        dfs(i,j,k);
                    }
                }
            }
            answer = Math.max(answer,cnt);
        }

        bw.write(answer + "");
        bw.flush();
    }

    private static void dfs(int height, int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 1 || nx > N || ny < 1 || ny > N) {
                continue;
            }

            if(!visited[nx][ny] && map[nx][ny] >= height) {
                visited[nx][ny] = true;
                dfs(height, nx, ny);
            }
        }
    }


}
