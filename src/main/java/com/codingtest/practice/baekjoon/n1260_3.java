package com.codingtest.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//DFS, BFS 문제 풀어보기
public class n1260_3 {


    static int n,edge[][];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int s) {
        Stack<Integer> stack = new Stack<>();
        visited = new boolean[n+1];
        stack.add(s);
        //int idx;
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            if(visited[idx]) continue;
            else visited[idx] = true;
            sb.append(idx + " ");
            for(int u=n; u>=1; u--) {
                if(edge[idx][u] == 1 && !visited[u]) {
                    stack.add(u);
                }
            }
        }
        System.out.println(sb);
    }

    public static void BFS(int s) {
        sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n+1];
        queue.add(s);
        while(!queue.isEmpty()) {
            int v = queue.poll();
            if(visited[v]) continue;
            else visited[v] = true;
            sb.append(v + " ");
            for(int u=1; u<=n; u++) {
                if(edge[v][u] == 1 && !visited[u]) {
                    queue.add(u);
                }
            }
        }
        System.out.println(sb);


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int c[][] = new int[m][2];
        int i,j;
        for(i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(j=0; j<2; j++) {
                c[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        edge = new int[n+1][n+1];
        for(i=0; i<m; i++)
            edge[c[i][0]][c[i][1]] = 1;
        for(i=0; i<m; i++)
            edge[c[i][1]][c[i][0]] = 1;

        DFS(v);
        BFS(v);
    }
}
