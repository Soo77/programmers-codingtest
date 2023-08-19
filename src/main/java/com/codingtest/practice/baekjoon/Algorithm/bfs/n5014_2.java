package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 스타트링크
public class n5014_2 {

    static int F, S, G, U, D;
    static boolean visited[];
    static int count[];
    static int flag = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 몇층건물
        S = Integer.parseInt(st.nextToken()); // 내 시작 위치
        G = Integer.parseInt(st.nextToken()); // 목표 층수
        U = Integer.parseInt(st.nextToken()); // 올라가는 버튼
        D = Integer.parseInt(st.nextToken()); // 내려가는 버튼

        visited = new boolean[F+1];
        count = new int[F+1];

        bfs(S,G);





    }

    private static void bfs(int start, int end) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        count[start] = 0;


        while(!que.isEmpty()) {
            int now = que.poll();

            if(now == end) {
                System.out.println(count[now]);
                flag=1;
                return;
            }

            for(int i=0; i<2; i++) {
                int next = 0;

                if(i==0) next = now + U;
                else next = now - D;

                if(next < 1 || next > F) continue;

                if(!visited[next]) {
                    visited[next] = true;
                    que.add(next);
                    count[next] = count[now] + 1;
                }
            }
        }
        System.out.println("use the stairs");
    }
}