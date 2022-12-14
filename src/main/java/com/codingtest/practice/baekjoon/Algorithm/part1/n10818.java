package com.codingtest.practice.baekjoon.Algorithm.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class n10818 {

    // 최소,최대

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        String num = br.readLine();
        StringTokenizer st = new StringTokenizer(num);

        List<Integer> numList = new ArrayList<>();
        for(int i=0; i<cnt; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numList);

        int min = numList.get(0);
        int max = numList.get(numList.size()-1);
        //System.out.println(min + " "+ max);
        bw.write(min + " " + max);
        bw.flush();
    }
}
