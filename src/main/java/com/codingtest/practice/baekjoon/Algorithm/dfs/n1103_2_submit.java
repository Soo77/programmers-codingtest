package com.codingtest.practice.baekjoon.Algorithm.dfs;

/*
* 4 4
3HH2
H1HH
H2H1
2219
* */

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class n1103_2_submit {

    static int N,M;
    static int board[][];
    static boolean visited[][];
    static String flag = "";
    static StringBuilder sb = new StringBuilder();
    static String miniS = "";
    static int count = 0;
    static int beforeX, beforeY = 0;
    static ArrayList<String> Slist = new ArrayList<>();
    static Stack<String> stlist = new Stack<>();

    static int max = 1;

    static int a,b,c,d,e=0;

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++) {
            String[] s = br.readLine().split("");
            for(int j=1; j<=M; j++) {
                if(s[j-1].equals("H")) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = Integer.parseInt(s[j-1]);
                }
            }
        }

        /*for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                System.out.print("("+i+","+j+"), ");
            }
            System.out.println();
        }*/

        //sb.append("(1,1) -> ");
        //Slist.add("(1,1) -> ");
        stlist.push("(1,1) -> ");
        dfs(1,1);


        if (flag.equals("recur")) {
            bw.write("-1");
        } else {
            bw.write(max+ "");
        }


        bw.flush();
    }

    private static void dfs(int startX, int startY) {

        if(flag.equals("recur")) {
            return;
        }

        int X = board[startX][startY] ;
        count = 1;

        for(int i=0; i<4; i++) {
            int x = startX;
            int y = startY;

            if(i==0) {
                y -= X;
            } else if(i==1) {
                y += X;
            } else if(i==2) {
                x += X;
            } else if(i==3) {
                x -= X;
            }


            if(x<=0 || x>N || y<=0 || y>M || board[x][y] == 0)  {
                continue;
            }

            stlist.push("("+x+","+y+") -> ");

            if(beforeX == x && beforeY == y || (x == 1 && y == 1)) {
                flag = "recur";
                return;
            }

            beforeX = startX;
            beforeY = startY;

            visited[x][y] = true;

            dfs(x,y);

            max = Math.max(max, stlist.size());

            if(visited[x][y]) {
                stlist.pop();
            }

            visited[x][y] = false;
            //a--;


        }
    }
}