package com.codingtest.practice.baekjoon.Algorithm.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n14719 {

    // 빗물..

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int h = Integer.parseInt(s.split(" ")[0]);
        int w = Integer.parseInt(s.split(" ")[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] height = new int[w];
        for(int i=0; i<height.length; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i=1; i<w-1; i++) {
            int left = 0;
            int right =0;

            for(int j=0; j<i; j++) {
                left = Math.max(height[j],left);
            }

            for(int j=i+1; j<w; j++) {
                right = Math.max(height[j],right);
            }

            int min = Math.min(left,right);
            int water = min-height[i];
            if(water > 0) {
                result += water;
            }
        }
        System.out.println(result);

    }
}
