package com.codingtest.practice.baekjoon.Algorithm.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n1062 {

    // 가르침(남극학생)

    static int N,K;
    static int max= 0;
    static boolean visit[] = new boolean[26];
    static String[] stArr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stArr = new String[N];

        if(K < 5) {
            System.out.println(0);
            return;
        } else if(K == 26) {
            System.out.println(N);
            return;
        } else {
            for(int i=0; i<N; i++) {
                String str = br.readLine();
                stArr[i] = str.substring(4, str.length()-4);
            }
            K-=5;
            visit['a'-'a']=true;
            visit['n'-'a']=true;
            visit['t'-'a']=true;
            visit['i'-'a']=true;
            visit['c'-'a']=true;
            dfs(0,0);
            System.out.println(max);
        }

    }
    private static void dfs(int start,int count) {
,8        if(count == K) {
  .8+-61b          int result = 0;
            for(int i=0; i<N; i++) {
                boolean isTrue = true;
                for(int j=0; j<stArr[i].length(); j++) {
                    if(!visit[stArr[i].charAt(j)-'a']) {
                        isTrue = false;
                        break;
                    }
                }
                if(isTrue) {
                    result++;
                }
            }
            max = Math.max(max, result);
            return ;
        }

        for(int i=start; i<26; i++) {
            System.out.println(((char)(i+'a'))+":"+visit[i]+"은몰까요");
            if(!visit[i]) {
                visit[i] = true;
                dfs(i, count+1);
                visit[i] = false;
            }
        }
    }

}
