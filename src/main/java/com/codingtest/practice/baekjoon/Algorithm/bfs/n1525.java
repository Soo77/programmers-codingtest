package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.*;

//1525 퍼즐
public class n1525 {

    static String correct = "123456780";
    static Map<String, Integer> map = new LinkedHashMap<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String init = "";
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                int num = Integer.parseInt(st.nextToken());
                init += num;
            }
        }

        map.put(init,0);
        System.out.println(bfs(init));



    }

    private static int bfs(String init) {
        Queue<String> q = new LinkedList<>();
        q.add(init);

        while(!q.isEmpty()) {
            String pos = q.poll();
            int move = map.get(pos);
            int empty = pos.indexOf('0');
            int px = empty%3;
            int py = empty/3;

            if(pos.equals(correct)) {
                return move;
            }

            for(int i=0; i<4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx <0 || ny <0 || nx >2 || ny>2) continue;

                int nPos = nx*3 + ny;
                char ch = pos.charAt(nPos);
                String next = pos.replace(ch,'c');
                next = next.replace('0', ch);
                next = next.replace('c', '0');

                if(!map.containsKey(next)) {
                    q.add(next);
                    map.put(next, move+1);
                }

            }
        }

        return -1;
    }
}