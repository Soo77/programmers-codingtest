package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.StringTokenizer;


public class n10026 {

    //적록색약

    private static int N;
    private static char map[][];

    private static boolean visited[][];

    private static int count = 0;
    private static int area = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        map = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    dfs(i,j);
                    count++;
                }
            }
        }

        bw.write(count + " ");

        count = 0;
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    dfs(i,j);
                    count++;
                }
            }
        }


        bw.write(count+"");
        bw.flush();
    }

    private static void dfs(int startX, int startY) {
        visited[startX][startY] = true;

        char now = map[startX][startY];

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        for(int i=0; i<4; i++) {
            int x = startX + dx[i];
            int y = startY + dy[i];

            if(x<0 || x>=N || y<0 || y>=N) {
                continue;
            }

            //System.out.println("x:"+x+",y:"+y);
            if(map[x][y] == now && !visited[x][y]) {
                dfs(x,y);
            }


        }
    }
}
