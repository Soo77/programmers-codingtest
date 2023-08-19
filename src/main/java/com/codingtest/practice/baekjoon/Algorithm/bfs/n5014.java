package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 스타트링크
public class n5014 {

    static int F, S, G, U, D;
    static boolean visited[];

    static int count = 0 ;

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

        bfs(S,G);

        if(count == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(count);
        }



    }

    private static void bfs(int start, int end) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;



        while(!que.isEmpty()) {
            int now = que.poll();
            System.out.println("now:"+now);


            int next = 0;

            if(now == end) return;

            System.out.println("now가 몇인데?"+now);
            System.out.println("next가 몇인데?"+next);

            if(now < end) {
                next = now + U;
                System.out.println("1now:"+now+", end:"+end + ", next:"+next);
            }

            System.out.println("2now가 몇인데?"+now);
            System.out.println("2next가 몇인데?"+next);
            if(now > end) {
                next = now - D;
                System.out.println("2now:"+now+", end:"+end + ", next:"+next);
            }

            if(next > end) {
                next = now - D;
                System.out.println("3now:"+now+", end:"+end + ", next:"+next);
            }

            //if(next < 1 || next > F) continue;

            if(!visited[next]) {
                que.add(next);
                visited[next] = true;
                System.out.println("@@@@@@@@@@@@@@@"+next);
                count++;
            }


        }
    }
}