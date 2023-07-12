package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.StringTokenizer;

public class n1743 {

    //음식물 피하기

    private static int N,M,K;
    private static int map[][];
    private static boolean visited[][];

    private static int nx[] = {0,0,-1,1};
    private static int ny[] = {-1,1,0,0};

    private static int count = 0;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        /*for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                //System.out.print(map[i][j] +  ",");
                System.out.print("("+i+","+j+"), ");
            }
            System.out.println();
        }*/


        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    //.out.println("main :"+i+", "+j);
                    count = 1;
                    dfs(i,j);
                    max = Math.max(max, count);
                }
            }
        }

        bw.write(max+"");
        bw.flush();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int dx = x + nx[i];
            int dy = y + ny[i];


            if(dx < 0  || dx > N || dy < 0 || dy > M) {
                continue;
            }

            if(map[dx][dy] == 1 && !visited[dx][dy]) {
                //System.out.println("sub: "+dx+","+dy);
                dfs(dx,dy);
                count++;
            }
        }


    }

}
