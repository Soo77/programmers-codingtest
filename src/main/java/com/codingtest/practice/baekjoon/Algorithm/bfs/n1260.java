package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// DFS와 BFS
public class n1260 {

    private static int N,M,V;
    private static int map[][];
    private static boolean visited[];
    private static StringBuilder sb = new StringBuilder();

    private static Queue<Integer> q = new LinkedList<>();

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



        dfs(V);

        visited = new boolean[N+1];

        System.out.println();
        bfs(V);

    }

    private static void bfs(int start) {

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {

            start = q.poll();
            System.out.print(start+ " ");

            for(int i=1; i<=N; i++) {
                if(map[start][i]==1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(int start) {
        visited[start] = true;

        System.out.print(start+ " ");

        for(int i=1; i<=N; i++) {
            if(map[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

    }


}
