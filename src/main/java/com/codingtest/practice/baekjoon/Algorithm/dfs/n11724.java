package com.codingtest.practice.baekjoon.Algorithm.dfs;

import java.io.*;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class n11724 {
    static int N,M;
    static int[][] a;
    static boolean[] node;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N+1][N+1];
        node = new boolean[N+1];
        for(int i=0; i<M; i++) {//간선의 개수만큼 반복
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a[x][y] = 1;
            a[y][x] = 1;
        }


        int count = 0;
        for(int i=1; i<N+1; i++) {
            if(node[i] == false) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int value) {

        if(node[value] == true) {
            return;
        }

        node[value] = true;
        for(int i=1; i<N+1; i++) {
            if(a[value][i] == 1) {
                dfs(i);
            }
        }
    }
}
