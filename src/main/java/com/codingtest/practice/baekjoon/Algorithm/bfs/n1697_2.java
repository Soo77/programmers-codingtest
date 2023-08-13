package com.codingtest.practice.baekjoon.Algorithm.bfs;


import java.io.*;
import java.util.*;

// 숨바꼭질
public class n1697_2 {

    static int N,K;
    static int visited[] = new int[100001];

    static int answer = Integer.MAX_VALUE;
    static int count = 0;

    static ArrayList<Integer> areaList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈
        K = Integer.parseInt(st.nextToken()); // 동생

        bfs(N);

        System.out.println(answer);
    }

    private static void bfs(int node) {

        Queue<Integer> que = new LinkedList<Integer>();

        que.add(node);
        int index = node;
        int n = 0;
        visited[index] = 1;
        while (!que.isEmpty())
        {
            n = que.remove();

            if (n == K)
            {
                if(answer < visited[n]){
                    return;
                }
                 answer = visited[n]-1;
                 count++;
            }

            if (n-1>=0 && visited[n-1] == 0)
            {
                visited[n-1] = visited[n]+1;
                que.add(n-1);
            }
            if (n+1 < 100001 && visited[n+1] == 0)
            {
                visited[n+1] = visited[n]+1;
                que.add(n+1);
            }
            if (2*n < 100001 && visited[2*n] == 0)
            {
                visited[2*n] = visited[n] + 1;
                que.add(2*n);
            }
            Iterator iter = que.iterator();
            System.out.print("[");
            while(iter.hasNext()) {
                System.out.print(iter.next()+",");
            }
            System.out.println("]");
            System.out.println( Arrays.toString(visited));
        }

    }


}
