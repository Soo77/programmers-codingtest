package com.codingtest.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

//DFS, BFS 문제 풀어보기
public class n1260_2 {

    /*
    * static 변수 특징
    *  - Static 변수는 클래스 변수이다.
    *  - 객체를 생성하지 않고도 Static 자원에 접근이 가능하다.
    *  - 메모리에 고정적으로 할당되어, 프로그램이 종료될 때 해제되는 변수이다.
    * */
    static int n, edge[][];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int s) {

        Stack<Integer> stack = new Stack<>();
        visited = new boolean[n+1];
        stack.add(s);
        while(!stack.empty()) {
            int v = stack.pop();
            if(visited[v]) continue; // v가 방문한 노드면 다시 처음으로
            visited[v] = true;
            sb.append(v+" ");
            for(int i=n; i>=1; i--){
                if(edge[v][i]==1 && !visited[i]) {
                    stack.add(i);
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
        int i,j;
        int c[][] = new int[m][2];
        for(i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(j=0; j<2; j++) {
                c[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(Arrays.deepToString(c));
        br.close();

        edge = new int[n+1][n+1];
        for(i=0; i<m; i++)
            edge[c[i][0]][c[i][1]] = 1;
        for(i=0; i<m; i++)
            edge[c[i][1]][c[i][0]] = 1;
        DFS(v);

    }
}
