package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class n2668_2 {

    //숫자 고르기

    private static int N;
    private static int map[][];
    private static boolean visited[];
    private static ArrayList<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[2][N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            map[0][i] = i;
            map[1][i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<2; i++) {
            for(int j=1; j<=N; j++) {
                System.out.print(map[i][j]+", ");
            }
            System.out.println();
        }

        for(int i=1; i<=N; i++) {
            visited[i] = true;
            System.out.println("main start, i:"+i);
            dfs(i, i);
            System.out.println("main end");
            visited[i] = false;
        }

        for(Integer i : list) {
            System.out.println(i);
        }

    }

    private static void dfs(int start, int target) {
        Arrays.toString(visited);
        if(visited[map[1][start]] == false) {
            visited[map[1][start]] = true;
            System.out.println("sub start, map[1]["+start+"]:"+map[1][start]+", target:"+target);
            dfs(map[1][start], target);
            System.out.println("sub end");
            visited[map[1][start]] = false;
        }
        System.out.println("middle start:"+start+", target:"+target);
        if(map[1][start] == target) {
            System.out.println("map[1]["+start+"]:"+map[1][start]+", target:"+target);
            list.add(target);
            System.out.println(target+"을 list에 추가!");
        }
    }
}
