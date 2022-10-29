package com.codingtest.practice.baekjoon.Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//DFS, BFS 문제 풀어보기
public class n1260 {

    static int N,M,V;
    static int graph[][];

    /*static void dfs(int start, boolean[] visited) {

        int num = start;
        visited[num] = true;
        System.out.print(num + " ");
        for(int i=1; i<=N; i++) {
            if(graph[num][i]==1 && visited[i] == false) {
                dfs(i,visited);
            }
        }

    }*/

    static void dfs(int start, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        int num = start;
        stack.add(num);

        while(!stack.isEmpty()) {
            num = stack.pop();
            if(visited[num]==true) continue;
            visited[num]=true;
            System.out.print(num + " ");
            for(int i=1; i<=N; i++) {
                if(graph[num][i]==1 && visited[i]==false) {
                    stack.add(i);
                    break;
                }
            }
        }

    }

    static  void bfs(int start, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        int num = start;
        q.add(num);

        while(!q.isEmpty()) {
            num = q.poll();
            if(visited[num]==true) continue;
            visited[num]=true;
            System.out.print(num + " ");
            for(int i=1; i<=N; i++) {
                if(graph[num][i]==1 && visited[i]==false) {
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws  Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String info = br.readLine();
        N= Integer.parseInt(info.split(" ")[0]);
        M= Integer.parseInt(info.split(" ")[1]);
        V= Integer.parseInt(info.split(" ")[2]);

        boolean[] visited = new boolean[N+1];
        graph = new int[N+1][N+1];

        for(int i=0; i<M; i++) {
            String s = br.readLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int m = Integer.parseInt(s.split(" ")[1]);
            graph[n][m]=graph[m][n]=1;
        }

        dfs(V, visited);

        System.out.println();
        visited = new boolean[N+1];
        bfs(V, visited);

    }
}
