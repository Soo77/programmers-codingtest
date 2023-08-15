package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질4
public class n13913 {

    static int N,K;
    static int[] parent = new int[100001];
    static int[] time = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈
        K = Integer.parseInt(st.nextToken()); // 동생

        bfs();

    }

    private static void bfs() {

        Queue<Integer> que = new LinkedList<Integer>();
        que.add(N);
        time[N] = 1;

        while(!que.isEmpty()) {
            int now = que.poll();

            if(now == K) return;

            for(int i=0; i<3; i++) {
                int next;

                if(i==0) next = now + 1;
                else if(i==1) next = now - 1;
                else next = now*2;

                if(next < 0 || next > 100000) continue;

                if(time[next] == 0) {
                    que.add(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                }
            }



        }

    }


}
