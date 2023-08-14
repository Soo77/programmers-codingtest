package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.*;

// 숨바꼭질3
public class n13549 {


    static int N,K;
    static int count = 0, result = Integer.MAX_VALUE;

    static ArrayList<Integer> areaList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈
        K = Integer.parseInt(st.nextToken()); // 동생

        int result = bfs(N);

        System.out.println(result);
        //System.out.println(count);


    }

    private static int bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        int visited[] = new int[100001];

        Arrays.fill(visited,-1);

        visited[start] = 0;

        while(!que.isEmpty()) {
            int pos = que.poll();
            int[] dir = {pos*2,pos-1,pos+1};

            for(int next : dir) {
                if(next < 0 || next > 100000) continue;
                if(visited[next] != -1) continue;
                if(next == pos * 2) {
                    visited[next] = visited[pos];
                } else {
                    visited[next] = visited[pos]+1;
                }
                que.add(next);
            }
        }
        return visited[K];
    }


}
