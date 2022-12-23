package com.codingtest.practice.baekjoon.Algorithm.part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n1062_2 {

    // 가르침(남극학생)

    static int N,K;
    static int max= 0;
    static boolean visit[] = new boolean[26];
    static String[] stArr;

    static int CNT = 0;

    public static void dfs(int start, int count) {

        if(count == K) {
            //System.out.println("count:"+count);
            int num = 0 ;
            for(int i=0; i<stArr.length; i++) {
                boolean flag = true;
                //System.out.println("stArr[i]:"+stArr[i]);
                for(int j=0; j<stArr[i].length(); j++) {
                   // System.out.println("stArr[i].charAt(j):"+stArr[i].charAt(j));
                    if(!visit[stArr[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if(flag) num++;
            }
            max = Math.max(max, num);
            System.out.println("max:"+max+", num:"+num);
            return;
        }

        for(int i=start; i<26; i++) {
            System.out.println("CNT:"+CNT+",i:"+i);
            if(!visit[i]) {
                visit[i] = true;
                System.out.println("visit의 "+i+"번째를 true로 변경");
                dfs(i, count+1);
                visit[i] = false;
            }
        }
        CNT++;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stArr = new String[N];

        if(K<5) {
            System.out.println("0"); return;
        } else if(K==26) {
            System.out.println(N);
            return;
        } else {
            for(int i=0; i<N; i++) {
                String str = br.readLine();
                stArr[i] = str.substring(4,str.length()-4);
                System.out.println(stArr[i]+"뽑아보기");
            }

            K-=5;

            visit['a' - 'a'] = true;
            visit['n' - 'a'] = true;
            visit['t' - 'a'] = true;
            visit['i' - 'a'] = true;
            visit['c' - 'a'] = true;

            dfs(0,0);
            System.out.println(max);

        }



    }

}
