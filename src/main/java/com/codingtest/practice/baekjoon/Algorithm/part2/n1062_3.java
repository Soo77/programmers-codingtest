package com.codingtest.practice.baekjoon.Algorithm.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1062_3 {

    // 가르침(남극학생)

    static int N,K;
    static int max= Integer.MIN_VALUE;
    static boolean visited[] = new boolean[26];
    static String[] strArr;

    public static void dfs(int start, int count) {

        //int cnt = 0;
        if (count == K - 5) {

            int cnt = 0;
            for (int i = 0; i < strArr.length; i++) {
                boolean chk = true;
                for (int j = 0; j < strArr[i].length(); j++) {
                    if (!visited[strArr[i].charAt(j) - 'a']) {
                        chk = false;
                        break;
                    }
                }
                if (chk) cnt++;
            }

            max = Math.max(max, cnt);
            return;
        }


        for (int i = start; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, count+1);
                visited[i] = false;
            }

        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        strArr = new String[N];

        if(K < 5) {
            max = 0;
        } else if(K == 26) {
            max = N;
        } else {
            for(int i=0; i<N; i++) {
                strArr[i]=br.readLine().replaceAll("anta|tica","");
            }

            visited['a' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;

        }

        dfs(0,0);
        System.out.println("답:"+max);
    }

}
