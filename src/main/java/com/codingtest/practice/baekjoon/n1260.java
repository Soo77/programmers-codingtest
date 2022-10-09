package com.codingtest.practice.baekjoon;

import java.io.*;
import java.util.*;

//DFS, BFS 문제 풀어보기
public class n1260 {

    static int n, edge[][]; //노드개수, 간선그래프
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int s) {
        Stack<Integer> stack = new Stack<>();
        visited = new boolean[n+1];
        stack.add(s);
        while(!stack.empty()) {
            int v = stack.pop();
            System.out.println("꺼낸애:"+v);
            if(visited[v]) continue;
            else visited[v] = true;
            sb.append(v+" ");
            System.out.println("스택상황:"+stack);
            System.out.println("붙인애:"+v);
            for(int i=n; i >=1; i--) {
                if(edge[v][i] == 1 && !visited[i]) {
                    System.out.println("들어온애 v:"+v+",i:"+i);
                    stack.add(i);
                }
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        //DFS(Depth First Search 깊이 우선 탐색)
        /*
        *  - 루트 노드에서 시작해서 다음 분기로 넘어가기 전에 해당 분기를 완벽하게
        *  탐색하는 방법
        *  - 넓게 탐색하기 전에 깊게 탐색하는 것이다.
        * */
        //방법1: 스택을 이용해서 풀기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 간선이 연결하는 두 정점
        int v = Integer.parseInt(st.nextToken()); // 탐색 시작할 정점
        int i, j;
        int c[][] = new int[m][2]; //주어지는 m 넣을 배열
        for(i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(j=0; j<2; j++) {
                c[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*
        * StringTokenizer 의
        * nextElement는 Object를 반환
        * nextToken은 String 을 반환한다고 한다.
        * */
        br.close();

        edge = new int[n+1][n+1];
        for(i=0; i<m; i++) {
            System.out.println("이게뭘까나1:: "+c[i][0]+","+c[i][1]);
            edge[c[i][0]][c[i][1]] = 1;
        }
        for(i=0; i<m; i++) {
            System.out.println("이게뭘까나2:: "+c[i][1]+","+c[i][0]);
            edge[c[i][1]][c[i][0]] = 1;
        }
        DFS(v);
        System.out.println(Arrays.deepToString(c));
        System.out.println(Arrays.deepToString(edge));



        //방법2: 재귀를 이용해서 풀기
    }
}
