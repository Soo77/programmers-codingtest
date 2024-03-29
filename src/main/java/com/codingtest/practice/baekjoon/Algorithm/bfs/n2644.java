package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//촌수계산
public class n2644 {

    private static int n,m;
    private static int start,end;
    private static int parents[][];
    private static boolean visited[];
    private static int ans[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        parents = new int[n+1][n+1];
        visited = new boolean[n+1];
        ans = new int[n+1];

        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            parents[x][y] = parents[y][x] = 1;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                System.out.print(parents[i][j] + ",");
            }
            System.out.println();
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                System.out.print("("+ i +","+j+")" + ",");
            }
            System.out.println();
        }

        bfs(start, end);

        ans[end] = ans[end] == 0 ? -1 : ans[end];
        System.out.println(ans[end]);
    }

    private static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();
            System.out.println("poll: "+temp+"를 꺼내보입니다..");
            if(temp == end) {
                System.out.println("temp:"+temp+", end:"+end+" 두개가 같으면 break!");
                break;
            }

            for(int i=1; i<=n; i++) {
                if(parents[temp][i] == 1 && !visited[i]) {
                    System.out.println("안에 for문 add...." +i+"를 add.......");
                    q.add(i);
                    visited[i] = true;
                    System.out.println("ans["+i+"] = ans["+temp+"] + 1"  );
                    ans[i] = ans[temp] + 1;
                }
            }

            System.out.println("ans:"+Arrays.toString(ans));
        }

    }


}
