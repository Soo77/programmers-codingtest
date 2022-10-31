package com.codingtest.practice.etc;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//그리디 알고리즘 예시
//1이 될때까지
public class Become1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> dwList = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<9; i++) {
            String input = br.readLine();
            dwList.add(Integer.parseInt(input));
            sum+=dwList.get(i);

        }
        Collections.sort(dwList);
        int fake1=0,fake2=0;
        loop:
        for(int i=0; i<dwList.size(); i++) {
            for(int j=0; j<dwList.size(); j++) {
                fake1= dwList.get(i);
                fake2 = dwList.get(j);
                if((sum - fake1 - fake2) == 100) {
                    fake1= i;
                    fake2= j;
                    break loop;
                }
            }
        }



        for(int i=0; i<dwList.size(); i++) {
            if(i == fake1 || i == fake2) {
                continue;
            }
            bw.write(String.valueOf(dwList.get(i))+"\n");

        }
        bw.flush();




    }
}
