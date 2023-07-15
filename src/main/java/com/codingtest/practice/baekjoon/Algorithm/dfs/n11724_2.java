package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.StringTokenizer;

public class n11724_2 {

    static int N,M;
    static int map[][];
    static boolean visited[];
    static int count = 0;

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }




        for(int i=1; i<=N; i++) {
            //visited = new boolean[N+1];
            if(!visited[i]){
                dfs(i);
                count++;
            }

        }


        System.out.println(count);


    }

    private static void dfs(int start) {
        if(visited[start]) return;

        visited[start] = true;

        for(int i=1; i<=N; i++) {
            if(map[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }


}
