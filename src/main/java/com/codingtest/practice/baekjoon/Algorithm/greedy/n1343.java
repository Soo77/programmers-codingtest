package com.codingtest.practice.baekjoon.Algorithm.greedy;

import java.io.*;

/*
* 민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB

이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다.

폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.
*
* */

public class n1343 {
    public static void main(String[] args) throws IOException {
        String input = "";
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input = bf.readLine();

        int count = 0;
        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i) == '.') {
                if(count%2 == 1) {
                    bw.write("-1");
                    bw.flush();
                    return;
                }
                count = 0;
            } else {
                count++;
            }

            if(i == (input.length() - 1)) {
                if(count%2==1) {
                    bw.write("-1");
                    bw.flush();
                    return;
                }
            }
        }

        String answer = input.replace("X","B");
        answer = answer.replace("BBBB", "AAAA");
        bw.write(answer);
        bw.flush();
    }
}
