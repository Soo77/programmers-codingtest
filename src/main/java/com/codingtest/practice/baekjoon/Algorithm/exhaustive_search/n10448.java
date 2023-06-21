package com.codingtest.practice.baekjoon.Algorithm.exhaustive_search;

import java.io.*;

public class n10448 {

    private static int findTriNum(int num) {
        //System.out.println("max:"+max);
        int max = 45;

        for(int i=1; i<max; i++) {
            for(int j=i; j<max; j++) {
                for(int k=j; k<max; k++) {
                    if((i*(i+1) + j*(j+1) + k*(k+1)) == (num*2)) {
                        //System.out.println(i+","+j+","+k);
                        return 1;
                    }
                }
            }
        }
        //System.out.println();
        return 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int result = findTriNum(Integer.parseInt(br.readLine()));
            bw.write(result+"\n");
        }




        bw.flush();


    }


}
