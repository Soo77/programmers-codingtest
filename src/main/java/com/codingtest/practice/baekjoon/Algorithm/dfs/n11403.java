package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.StringTokenizer;

public class n11403 {

    static int N;
    static int[][] graph;
    static int[][] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N];
        result = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                //System.out.println(j+"를 false로");
                visited[j] = false;
            }

            for(int j=0; j<N; j++) {
                if(graph[i][j] == 1 && visited[j] == false) {
                    dfs(i,j);
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }



    }

    private static void dfs(int x, int y) {
        visited[y] = true;
        result[x][y] = 1;

        for(int i=0; i<N; i++) {
            if(graph[y][i] == 1 && visited[i] == false) {
                dfs(x,i);
            }
        }
    }


}
