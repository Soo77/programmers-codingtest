package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class n1987 {

    //dfs 알파벳
    private static int R,C;
    private static char map[][];
    private static boolean visited[][];

    //private static Set<Character> list = new HashSet<>();
    private static ArrayList<Character> list = new ArrayList<>();
    private static int count = 0;
    private static int count2 = 0;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R+1][C+1];
        visited = new boolean[R+1][C+1];

        for(int i=1; i<=R; i++) {
            String s = br.readLine();
            for(int j=1; j<=C; j++) {
                map[i][j] = s.charAt(j-1);
            }
        }

        for(int i=1; i<=R; i++) {
            for(int j=1; j<=C; j++) {
                System.out.print("(" + i + "," + j + "), ");
            }
            System.out.println();
        }

        for(int i=1; i<=R; i++) {
            for(int j=1; j<=C; j++) {
                System.out.print(map[i][j]+",");
            }
            System.out.println();
        }

        /*for(int i=1; i<=R; i++) {
            for(int j=1; j<=C; j++) {
                if(!visited[i][j]) {
                    count=1;
                    System.out.println("main start");
                    dfs(i,j);
                    System.out.println("main end");
                    count++;
                }
            }

        }*/

        System.out.println("main start");
        dfs(1,1);
        System.out.println("main end");

        System.out.println("count:"+count);
        System.out.println("max:"+max);

    }

    private static void dfs(int startX, int startY) {
        System.out.println("\n\nnow: ("+startX+","+startY+")");
        visited[startX][startY] = true;
        list.add(map[startX][startY]);
        System.out.println("map["+startX+"]["+startY+"]="+map[startX][startY]);

        System.out.println("startX:"+startX+", startY:"+startY);
        for(Character cc : list) System.out.print(cc + ",");
        System.out.println();

        int dx[] = {0,0,-1,1};
        int dy[] = {1,-1,0,0};

        for(int i=0; i<4; i++) {
            int x = startX + dx[i];
            int y = startY + dy[i];

            if(x<=0 || x>R || y<=0 || y>C) {
                continue;
            }

            if(!list.contains(map[x][y]) && !visited[x][y]) {
                System.out.println("sub start");
                dfs(x,y);
                System.out.println("sub end");
            }
        }

        System.out.println("list size:"+list.size());
        max = Math.max(max,list.size());
        list.remove(list.size()-1);
        visited = new boolean[R+1][C+1];

    }
}
