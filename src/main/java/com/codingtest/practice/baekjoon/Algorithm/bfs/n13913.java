package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질4
public class n13913 {

    static int N,K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈
        K = Integer.parseInt(st.nextToken()); // 동생

        bfs(N);

    }

    private static void bfs(int start) {

        Queue<Integer> que = new LinkedList<Integer>();
        int[] visited = new int[100001];
        que.add(start);

        while(!que.isEmpty()) {
            int pos = que.poll();
            System.out.println("pos:"+pos);

        }

    }


}
