package com.codingtest.practice.baekjoon.Algorithm.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1062_5 {

    static int N,K;
    static boolean visited[] = new boolean[26];
    static String strArr[];
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K < 5) {
            System.out.println(0);
            return ;
        } else if (K == 26) {
            System.out.println(N);
            return ;
        }

        strArr = new String[N];
        for(int i=0; i<N; i++) {
            strArr[i] = br.readLine().replaceAll("anta|tica","");
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        check(0,0);
        System.out.println(answer);
    }

    private static void check(int start, int count) {
        if(count == K - 5) {
            int temp = 0;
            for(int i=0; i<strArr.length; i++) {
                boolean flag = true;
                for(int j=0; j<strArr[i].length(); j++) {
                    if(!visited[strArr[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if(flag) temp++;
                answer = Math.max(answer, temp);
            }
        }

        for(int i=start; i<26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                check(i, count + 1);
                visited[i] = false;
            }
        }
    }
}
