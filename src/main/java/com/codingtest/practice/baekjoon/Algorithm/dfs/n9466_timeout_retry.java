package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n9466_timeout_retry {

    //텀 프로젝트 timeout retry

    private static int T,N, res;
    private static int arr[];
    private static boolean visited[], done[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;

        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            res = 0;
            arr = new int[N+1];
            done = new boolean[N+1];
            visited = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=1; j<=N; j++) {
                if(done[j]) continue;;
                dfs(j);
            }

            bw.write((N - res) + "\n");
        }
        bw.flush();
    }

    private static void dfs(int idx) {
        if(done[idx]) return;
        if(visited[idx]) {
            done[idx] = true;
            res++;
        }
        visited[idx] = true;
        dfs(arr[idx]);
        done[idx] = true;
        visited[idx] = false;
    }
}
