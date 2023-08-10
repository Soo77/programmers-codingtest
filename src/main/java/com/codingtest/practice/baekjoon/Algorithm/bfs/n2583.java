package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.*;

// 영역 구하기
public class n2583 {

    static int N,M,K;
    static int map[][];
    static boolean visited[][];

    static ArrayList<Integer> answerlist = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M+1][N+1];
        visited = new boolean[M+1][N+1];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            x1+=1;
            y1+=1;

            for(int j=x1; j<=x2; j++) {
                for(int k=y1; k<=y2; k++) {
                    map[j][k] = 1;
                }
            }

        }

        int count =0;
        for(int i=1; i<=M; i++) {
            for(int j=1; j<=N; j++) {
                if(!visited[i][j] && map[i][j] == 0) {
                    int data = bfs(i,j);
                    answerlist.add(data);
                    count++;
                }
            }
        }

        Collections.sort(answerlist);
        System.out.println(count);
        for(Integer i : answerlist) {
            System.out.print(i+" ");
        }

    }

    private static int bfs(int startX, int startY) {
        visited[startX][startY] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{startX, startY});
        int area = 1;

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        while(!que.isEmpty()) {
            int[] poll = que.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            for(int i=0; i<4; i++) {
                int x = nowX + dx[i];
                int y = nowY + dy[i];

                if(x<=0 || x>M || y<=0 || y>N) {
                    continue;
                }

                if(map[x][y]==0 && !visited[x][y]) {
                    visited[x][y] = true;
                    que.add(new int[]{x,y});
                    area++;
                }
            }

            //System.out.println("area:"+area);
        }
        return area;
    }


}
