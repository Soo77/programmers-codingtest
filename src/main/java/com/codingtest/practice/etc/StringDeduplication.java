package com.codingtest.practice.etc;

import java.util.ArrayList;
import java.util.List;

//DFS, BFS 문제 풀어보기
public class StringDeduplication {

    public static void main(String[] args) {


        List<String> answer = new ArrayList<>();
        String input ="ghhrkkb";
        for(int i=0; i<input.length(); i++) {
            String s = input.split("")[i];
            if(i==0) {
                answer.add(s);
                continue;
            }
            else {
                if(s.equals(input.split("")[i-1])) {
                    continue;
                } else {
                    answer.add(s);
                }
            }
        }

        System.out.println(answer.toString());

        String[] finalArr = answer.toArray(new String[answer.size()]);


    }
}
