package com.codingtest.practice.baekjoon.Algorithm.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n11047 {
    public static void main(String[] args) throws IOException {




        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int coinCnt = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        int arrLen = 0;
        int[] coin = new int[coinCnt];
        for(int i=0; i<coinCnt; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp > money) {
                break;
            }
            coin[i] = temp;
            arrLen++;
        }

        int[] finalCoinArr = Arrays.copyOfRange(coin, 0, arrLen);

        int result = 0;
        for(int i=arrLen-1; i>=0; i--) {
            if(money == 0) break;
            result += (money/finalCoinArr[i]);
            money %= finalCoinArr[i];
        }

        bw.write(String.valueOf(result));
        bw.flush();


    }
}
