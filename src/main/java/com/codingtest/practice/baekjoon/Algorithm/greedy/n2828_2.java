package com.codingtest.practice.baekjoon.Algorithm.greedy;

import java.io.*;

public class n2828_2 {
    public static void main(String[] args) throws IOException {
        int screenSize = 0;
        int boxSize = 0;
        int appleCnt = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = bf.readLine().split(" ");
        screenSize = Integer.parseInt(temp[0]);
        boxSize = Integer.parseInt(temp[1]);
        //System.out.println(screenSize+","+boxSize);

        appleCnt = Integer.parseInt(bf.readLine());
        int position[] = new int[appleCnt];
        for(int i=0; i<appleCnt; i++) {
            position[i] = Integer.parseInt(bf.readLine());
        }

        int left = 1;
        int right = 1 + (boxSize - 1);
        int moveCnt = 0;
        for(int i=0; i<position.length; i++) {
            if(right < position[i]) {
                moveCnt += position[i] - right;
                right = position[i];
                left = right - (boxSize - 1);
            } else if(left > position[i]) {
                moveCnt += left - position[i];
                left = position[i];
                right = left + (boxSize - 1);
            }


        }
        bw.write(String.valueOf(moveCnt));
        bw.flush();


    }
}
