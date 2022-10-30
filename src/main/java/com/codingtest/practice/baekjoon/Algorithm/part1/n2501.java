package com.codingtest.practice.baekjoon.Algorithm.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class n2501 {

    //  약수 구하기

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int num = Integer.parseInt(input.split(" ")[0]);
        int idx = Integer.parseInt(input.split(" ")[1]);
        List<Integer> divList = new ArrayList<>();



        for(int i=1; i<=Math.sqrt(num); i++) {
            if(num%i==0) {

                divList.add(i);

                if(!divList.contains((num/i))) {
                    divList.add((num/i));

                }
            }
        }

        Collections.sort(divList);


        String result = "0";
        if (idx <= divList.size()) {
            result = String.valueOf(divList.get(idx-1));
        }
        String result2 = String.valueOf(result);
        bw.write(result);
        bw.flush();


    }
}
