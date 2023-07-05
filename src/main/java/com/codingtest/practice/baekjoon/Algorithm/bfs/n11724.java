package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n11724 {

    static int N,M;
    static int[][] a;
    static boolean[] node;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N+1][N+1];
        node = new boolean[N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a[x][y] = 1;
            a[y][x] = 1;
        }

        for(int i=1; i<N+1; i++) {
            if(!node[i]) {
                bfs(i);
            }
        }

        System.out.println(count);
    }

    private static void bfs(int value) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(value);
        count++;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            node[now] = true;
            for(int i=1; i<N+1; i++) {
                if(!node[i] && a[now][i]==1) {
                    queue.add(i);
                    node[i] = true;
                }
            }
        }
    }


}
