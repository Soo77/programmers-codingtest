package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// 나이트의 이동
public class n7562_submit {

    static int N,M;
    static int map[][];
    static boolean visited[][];

    static int endX = 0;
    static int endY = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T  = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];


            bfs(startX,startY);

            System.out.println(map[endX][endY]);
        }



    }

    private static void bfs(int startX, int startY) {

        //Queue<int[]> que = new LinkedList<>();
        Queue<int[]> que = new LinkedList<>() {
            @Override public String toString() {
                return "[" +
                        stream()
                                .map(Arrays::toString)
                                .collect(Collectors.joining(", ")) +
                        "]";
            }
        };
        visited[startX][startY] = true;

        que.add(new int[]{startX,startY});

        int[] dx = {-1,-2,-2,-1,1,2,2,1};
        int[] dy = {-2,-1,1,2,-2,-1,1,2};

        while(!que.isEmpty()) {
            int[] poll = que.poll();
            int nowX = poll[0];
            int nowY = poll[1];


            //System.out.println("nowX:"+nowX+",nowY:"+nowY);

            if(nowX == endX && nowY == endY) {
                return;
            }

            for(int i=0; i<8; i++) {
                int x = nowX + dx[i];
                int y = nowY + dy[i];

                if(x<0 || x>=N || y<0 || y>=N) {
                    continue;
                }

                if(!visited[x][y]) {
                    que.add(new int[]{x,y});
                    map[x][y] = map[nowX][nowY] + 1;
                    visited[x][y] = true;


                }




            }
        }
    }


}
