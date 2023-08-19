package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 숨바꼭질4
public class n13913_2 {

    static int N,K;
    static int parent[] = new int[100001];
    static int time[] = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(N+","+K);

        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while(index != N) {
            System.out.println("parent[index]):"+parent[index]);
            stack.push(parent[index]);
            index = parent[index];
            System.out.println("index:"+index);
        }

        System.out.println("타임케이: "+time[K]);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }


    }

    private static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        time[N] = 0;

        while(!que.isEmpty()) {
            int now = que.poll();

            System.out.println("now:"+now);

            if(now == K) return;

            for(int i=0; i<3; i++) {
                int next = 0;

                if(i == 0) next = now + 1;
                else if(i == 1) next = now - 1;
                else next = now*2;

                if(next < 0 || next > 100000) continue;

                if(time[next] == 0) {
                    que.add(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                    System.out.println(next+"왈: 나 "+ now +"에서 왔어~");
                }

            }
        }
    }
}