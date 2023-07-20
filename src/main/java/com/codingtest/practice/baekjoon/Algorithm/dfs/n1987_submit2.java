package com.codingtest.practice.baekjoon.Algorithm.dfs;


import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;


public class n1987_submit2 {

    //dfs 알파벳
    private static int R,C;
    private static int dx[] = {0,0,-1,1};
    private static int dy[] = {1,-1,0,0};
    private static char map[][];

    private static int result = 0;
    private static HashSet<Character> hs = new HashSet<>();

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        hs.add(map[0][0]);
        dfs(0, 0, 1);

        bw.write(result+"");
        bw.flush();

    }

    private static void dfs(int x, int y, int count) {
        for(int i=0; i<4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if(tx < 0 || tx >= R || ty < 0 || ty >= C) {
                continue;
            }

            if(hs.contains(map[tx][ty])) {
                result = Math.max(result, count);
            } else {
                hs.add(map[tx][ty]);
                dfs(tx,ty,count+1);
                hs.remove(map[tx][ty]);
            }
        }
    }

    /* private static void dfs(int startX, int startY) {
        visited[startX][startY] = true;
        list.add(map[startX][startY]);



        for(int i=0; i<4; i++) {
            int x = startX + dx[i];
            int y = startY + dy[i];

            if(x<=0 || x>R || y<=0 || y>C) {
                continue;
            }

            if(!list.contains(map[x][y]) && !visited[x][y]) {
                dfs(x,y);
            }
        }

        max = Math.max(max,list.size());
        list.remove(list.size()-1);
        visited = new boolean[R+1][C+1];

    }*/
}
