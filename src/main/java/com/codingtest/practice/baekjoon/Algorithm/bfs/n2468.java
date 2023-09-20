package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 안전영역
public class n2468 {

    static int N,M;
    static int map[][];
    static int map2[][];
    static boolean visited[][];

    static int answer= 0;
    static int count = 0;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        map2 = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];


        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
            }
        }


        for(int r=0; r<=max; r++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(map[i][j] > r && !visited[i][j]) {
                        bfs(i,j,r);
                        count++;
                    }
                }
            }
            visited = new boolean[N+1][N+1];
            answer = Math.max(count,answer);
            count=0;
        }

        System.out.print(answer);

    }

    private static void bfs(int startX, int startY, int height) {
        visited[startX][startY] = true;
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{startX, startY});

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        while(!que.isEmpty()) {

            int poll[] = que.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            for(int i=0; i<4; i++) {
                int x = nowX + dx[i];
                int y = nowY + dy[i];

                if(x<=0 || x>N || y<=0 || y>N) {
                    continue;
                }

                if(map[x][y] > height && !visited[x][y]) {
                    visited[x][y] = true;
                    map2[x][y] = 1;
                    que.add(new int[]{x, y});
                }
            }

            //visited = new boolean[R+1][R+1];
        }
    }


}
