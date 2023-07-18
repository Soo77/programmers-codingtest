package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.ArrayList;


public class n2668 {

    //숫자 고르기

    private static int N;
    private static int map[];
    private static boolean visited[];

    private static int num = 0;
    private static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        result = new ArrayList<>();

        map = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
           map[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=N; i++) {
            System.out.println(i+"번째 체크하기");
            visited[i] = true;
            num = i;
            System.out.println("num:"+num);
            System.out.println("dfs메인 시작");
            dfs(i);
            System.out.println(i+"번째 체크풀기");
            visited[i] = false;
        }




        bw.write(result.size() + "\n");
        for(Integer c : result) bw.write(c + "\n");
        bw.flush();
    }

    private static void dfs(int i) {
        System.out.println("dfs시작 map[i]="+map[i]+", num:"+num+", i:"+i);
        if(map[i]==num) {
            System.out.println(num+"을 더할게~~");
            result.add(num);
        } else {
            System.out.println(map[i]+"이랑 "+num+"이랑 안똑같아");
        }

        System.out.println(map[i]+"에 방문했나 안했나 검사");
        if(!visited[map[i]]) {
            System.out.println(map[i]+"에 방문을 안했구나~");
            visited[map[i]] = true;
            System.out.println("dfs 서브시작");
            dfs(map[i]);
            System.out.println(map[i]+"체크풀기");
            visited[map[i]] = false;
        }
    }
}
