package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.*;

// 숨바꼭질2
public class n12851 {

    static int[] dx = {-1,1,2};
    static int N,K;
    static int count = 0, result = Integer.MAX_VALUE;

    static ArrayList<Integer> areaList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈
        K = Integer.parseInt(st.nextToken()); // 동생

        bfs(N);

        System.out.println(result);
        System.out.println(count);
    }

    private static void bfs(int start) {

        Queue<Integer> que = new LinkedList<Integer>();
        int[] visited = new int[100001];
        que.add(start);

        while(!que.isEmpty()) {
            int pos = que.poll();
            System.out.println("pos:"+pos);

            if(result < visited[pos]) {
                System.out.println("result:"+result+", visited[pos]:"+visited[pos]+"이때 리턴");
                return;
            }
            if(visited[pos] <= result && pos == K) {
                result = visited[pos];
                count++;
            }

            for(int i=0; i<3; i++) {
                int next = pos;
                if(i==2) {
                    next = pos * dx[i];
                } else {
                    next = pos + dx[i];
                }

                ////System.out.println("next:"+next+", pos:"+pos);
                if(next >= 0 && next < 100001) {
                    if(visited[next] == 0 || visited[next] >= visited[pos] + 1) {
                        visited[next] = visited[pos] + 1;
                        que.add(next);
                    }
                }
            }
            System.out.println("next:"+pos);
        }

    }


}
