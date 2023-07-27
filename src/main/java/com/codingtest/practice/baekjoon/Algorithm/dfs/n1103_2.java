package com.codingtest.practice.baekjoon.Algorithm.dfs;

/*
* 4 4
3HH2
H1HH
H2H1
2219



3 4
3552
5555
2553
* */

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class n1103_2 {

    static int N,M;
    static int board[][];
    static boolean visited[][];
    static boolean finished[][];
    static String flag = "";
    static StringBuilder sb = new StringBuilder();
    static String miniS = "";
    static int count = 0;
    static int beforeX, beforeY = 0;
    static ArrayList<String> Slist = new ArrayList<>();
    static Stack<String> stlist = new Stack<>();

    static ArrayList<String> firstList = new ArrayList<>();

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
        finished = new boolean[N+1][M+1];

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

        for(int i=1; i<=N; i++) {
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
        }

        sb.append("(1,1) -> ");
        Slist.add("(1,1) -> ");
        stlist.push("(1,1) -> ");
        dfs(1,1);

        System.out.println(sb);
        for(int i=0; i<Slist.size(); i++) {
            System.out.print(Slist.get(i));
        }
        for(int i=0; i<stlist.size(); i++) {
            System.out.print(stlist.get(i));
        }
        System.out.print("\nfirstList:");
        for(int i=0; i<firstList.size(); i++) {
            System.out.print(firstList.get(i));
        }

        if (flag.equals("recur")) {
            bw.write("\n재귀: -1");
        } else {
            bw.write("\ncount:"+count +"\n");
            bw.write("max:"+max);
        }


        bw.flush();
    }

    private static void dfs(int startX, int startY) {

        if(a==250) flag = "recur";

        if(flag.equals("recur")) {
            System.out.println("재귀일때의 miniS:"+miniS);
            System.out.println("재귀구만 튀튀");
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

            a++;
            System.out.println("("+startX+","+startY+") -> ("+x+","+y+") a++ a:"+a );
            sb.append("("+x+","+y+") -> ");
            Slist.add("("+x+","+y+") -> ");
            miniS += "("+x+","+y+") -> ";
            stlist.push("("+x+","+y+") -> ");

            if( (beforeX == x && beforeY == y) || visited[x][y]) {
                flag = "recur";
                return;
            }


            beforeX = startX;
            beforeY = startY;

            visited[x][y] = true;

            for(int j=1; j<=N; j++) {
                for(int k=1; k<=M; k++) {
                    System.out.print(visited[j][k]+",");
                }
                System.out.println();
            }

            System.out.println("sub dfs start");
            dfs(x,y);

            for(int j=0; j<stlist.size(); j++) {
                System.out.print(stlist.get(j));
            }
            System.out.println("  stlist크기:"+stlist.size());
            max = Math.max(max, stlist.size());

            if(visited[x][y]) {
                System.out.println("여기가어디지 이걸지워야하나 ("+x+","+y+")");
                stlist.pop();
            }



            if(stlist.size() == 1) {
                System.out.println("여기가 어디지 이걸로 싸이클알수있나 ("+x+","+y+")");
                firstList.add("("+x+","+y+")");
            }

            visited[x][y] = false;
            //a--;
            System.out.println("inner: "+sb);
            System.out.print("stlist:");




            count++;
            System.out.println("\ncount:"+count);
            System.out.println("sub dfs end count++ count:"+count);

            finished[x][y]=true;
        }
    }
}