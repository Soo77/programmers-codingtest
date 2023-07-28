package com.codingtest.practice.baekjoon.Algorithm.dfs;


//MT
import java.io.*;
import java.util.StringTokenizer;

public class n10265 {

    private static int n,k=0;
    private static int arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 사람수
        k = Integer.parseInt(st.nextToken()); // 버스에 태울  수 있는 사람 수
        arr = new int[n+1];

        String s[] = br.readLine().split(" ");

        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(s[i-1]);
        }

        for(int i=1; i<=n; i++) {
            System.out.print(arr[i]);
        }

    }
}