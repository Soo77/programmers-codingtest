package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 안전영역
public class n2468_2 {

    static int N;
    static int map[][];
    static boolean visited[][];

    static int maxHeight = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(map[i][j], maxHeight);
            }
        }


        int count = 0, answer = 0;
        for(int h=0; h<=maxHeight; h++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(map[i][j] > h && !visited[i][j]) {
                        bfs(i,j,h);
                        count++;
                    }
                }
            }
            visited = new boolean[N+1][N+1];
            //System.out.println("count:"+count);
            answer = Math.max(answer, count);
            count = 0;

        }

        System.out.println(answer);


    }

    private static void bfs(int startX, int startY, int height) {
        visited[startX][startY] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{startX, startY});

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        while(!que.isEmpty()) {
            int[] poll = que.poll();
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
                    que.add(new int[]{x,y});
                }
            }

        }
    }

}
