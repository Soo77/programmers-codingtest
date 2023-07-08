package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n11403 {

    static int[][] graph;
    static int[][] result;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        result = new int[N][N];
        

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            visited = new boolean[N];
            bfs(i);
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);

        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int i=0; i<N; i++) {
                if(graph[temp][i] == 1 && visited[i] == false) {
                    q.offer(i);
                    visited[i] = true;

                    result[start][i] = 1;
                }
            }
        }
    }


}
