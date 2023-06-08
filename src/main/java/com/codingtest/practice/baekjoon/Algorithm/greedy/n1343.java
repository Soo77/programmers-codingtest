package com.codingtest.practice.baekjoon.Algorithm.greedy;

import java.io.*;

public class n1343 {
    public static void main(String[] args) throws IOException {
        String input = "";
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input = bf.readLine();

/*        if(input.length() == 1 && !input.equals(".")) {
            bw.write("-1");
            bw.flush();
            return;
        }*/

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
