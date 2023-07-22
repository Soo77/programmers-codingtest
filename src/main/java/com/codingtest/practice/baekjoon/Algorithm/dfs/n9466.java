package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class n9466 {

    //텀 프로젝트

    private static int N;
    private static int map[];
    private static boolean visited[];

    private static int num = 0;
    private static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            result = new ArrayList<>();

            N = Integer.parseInt(br.readLine());
            map = new int[N+1];
            visited = new boolean[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=1; j<=N; j++) {
                visited[j] = true;
                num = j;
                dfs(j);
                visited[j] = false;
            }

            //bw.write("result size:"+result.size() + "\n");
            //for(Integer c : result) bw.write(c + " ");
            //System.out.println();
            bw.write((map.length - result.size() - 1) +  "\n");
        }


        bw.flush();
    }

    private static void dfs(int i) {
        if(map[i]==num) {
            result.add(num);
        } else {
        }

        if(!visited[map[i]]) {
            visited[map[i]] = true;
            dfs(map[i]);
            visited[map[i]] = false;
        }
    }
}
