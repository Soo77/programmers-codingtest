package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n1103 {

    //게임

    static int N,M;
    static int[][] board;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            String[] s = br.readLine().split("");
            for(int j=1; j<=M; j++) {
                board[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                System.out.print(board[i][j]+",");
            }
            System.out.println();
        }

        for(int i=0; i<=N; i++) {
            for(int j=0; j<=M; j++) {
                System.out.print("("+i+","+j+"), ");
            }
            System.out.println();
        }

        dfs(1,1);

    }

    private static void dfs(int startX, int startY) {
        int X = board[startX][startY];
        System.out.println("X:"+X);

        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};
        for(int i=0; i<4; i++) {
            int x = dx[i]+startX;
            int y = dy[i]+startY;

            if(x<=0 || x>N || y<=0 || y>M) {
                 continue;
            }
            System.out.println(x+","+y);


        }
    }

}
