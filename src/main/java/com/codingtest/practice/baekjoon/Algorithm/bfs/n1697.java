package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.*;

// 숨바꼭질
public class n1697 {

    static int N,K;
    static int map[][];
    static boolean visited[][];

    static ArrayList<Integer> areaList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈
        K = Integer.parseInt(st.nextToken()); // 동생

        int answer = bfs(N);

    }

    private static int bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);


        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>() {{add(5);}});
        list.add(new ArrayList<>() {{add(5);}});
        list.add(new ArrayList<>() {{add(5);}});



        int count = 1;

        while(!que.isEmpty()) {

            Iterator iter = que.iterator();
            System.out.print("[");
            while(iter.hasNext()) {
                System.out.print(iter.next()+",");
            }
            System.out.println("]");

            for(int i=0; i<3; i++) {
                System.out.println(list.get(i).toString());
            }

            int poll = que.poll();

            int[] dir = {-1,1,poll};

            for(int i=0; i<3; i++) {
                System.out.println("poll:"+poll+", dir[i]: " + dir[i]);
                int now = poll + dir[i];

                que.add(now);

                list.get(i).add(now);

                System.out.println("now:"+now);
                count++;


                if(count==50) {
                    return -1;
                }

            }
        }

        return count;
    }


}
