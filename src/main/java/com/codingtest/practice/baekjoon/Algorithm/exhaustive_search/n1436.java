package com.codingtest.practice.baekjoon.Algorithm.exhaustive_search;

import java.io.*;

// 영화감독 숌
public class n1436 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String result = printMovieName(N);

        bw.write(result);
        bw.flush();


    }

    private static String printMovieName(int num) {
        int[] movieNum = new int[10001];

        movieNum[1] = 666;
        for(int i=2; i<=6; i++) {
            movieNum[i] = Integer.parseInt((i-1) + "666");
        }
        movieNum[7] = 6660;

        if(num>7) {
            int count = movieNum[7];
            for(int i=8; i<=num; i++) {
                int temp = ++count;
                //System.out.println("temp:"+temp);
                if(String.valueOf(temp).contains("666")) {
                    movieNum[i] = temp;
                } else {
                    i--;
                }
            }
        }


        //System.out.println(Arrays.toString(movieNum));



        return movieNum[num] + "";
    }


}
