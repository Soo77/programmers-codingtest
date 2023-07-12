package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.StringTokenizer;

public class n1260 {

    //음식물 피하기

    private static int N,M,V;
    private static int map[][];
    private static boolean visited[];

    private static int count = 0;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                System.out.print(map[i][j] +  ",");
            }
            System.out.println();
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                //System.out.print(map[i][j] +  ",");
                System.out.print("("+i+","+j+"), ");
            }
            System.out.println();
        }


        dfs(V);

        bw.write(sb+"");
        bw.flush();
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");

        for(int i=1; i<=N; i++) {
            if(map[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

    }

}
