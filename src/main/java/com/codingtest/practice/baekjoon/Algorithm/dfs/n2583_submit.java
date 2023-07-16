package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class n2583_submit {

    //영역 구하기

    private static int N,M,K;
    private static int map[][];
    private static boolean visited[][];

    private static int count = 0;
    private static int area = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> areaList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        int x=0,y=0;
        int x1=0,y1=0;
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            for(int j=y; j<y1; j++) {
                for(int k=x; k<x1; k++) {
                    map[k][j]= 1;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    area = 1;
                    dfs(i, j);
                    count++;
                    areaList.add(area);
                }

            }

        }

        Collections.sort(areaList);
        bw.write(count+"\n");
        for(int i=0; i<areaList.size(); i++) {
            bw.write(areaList.get(i)+ " ");
        }

        bw.flush();
    }

    private static void dfs(int startX, int startY) {
        visited[startX][startY] = true;

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        for(int i=0; i<4; i++) {
            int x = startX + dx[i];
            int y = startY + dy[i];

            if(x<0 || x>=N || y<0 || y>=M) {
                continue;
            }

            //System.out.println("x:"+x+",y:"+y);
            if(map[x][y] == 0 && !visited[x][y]) {
                dfs(x,y);
                area++;
            }


        }
    }


}
