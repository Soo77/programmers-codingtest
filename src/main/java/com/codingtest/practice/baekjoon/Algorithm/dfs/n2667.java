package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class n2667 {

    //단지번호붙이기

    private static int N;
    private static int map[][];
    private static boolean visited[][];

    private static int danji = 0;
    private static int count = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> house = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            for(int j=1; j<=N; j++) {
                map[i][j] = s.charAt(j-1) - '0';
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(i,j);
                    danji++;

                    house.add(count);
                }
            }
        }

        Collections.sort(house);
        //System.out.println(danji+",");
        bw.write(danji + "\n");
        for(int i=0; i<danji; i++) {
            bw.write(house.get(i) + "\n");
        }
        bw.write("");
        bw.flush();
    }

    private static void dfs(int startX, int startY) {
        visited[startX][startY] = true;

        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};

        for(int i=0; i<4; i++) {
            int x = dx[i] + startX;
            int y = dy[i] + startY;

            if(x < 0 || x > N || y < 0 || y > N) {
                continue;
            }

            if(map[x][y] == 1 && !visited[x][y]) {
                dfs(x,y);
                count++;
            }
        }
    }

}
