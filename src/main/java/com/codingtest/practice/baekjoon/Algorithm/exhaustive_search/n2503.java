package com.codingtest.practice.baekjoon.Algorithm.exhaustive_search;

import java.io.*;

// 숫자 야구
public class n2503 {

	static int N;
	static BaseBall[] box;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
		box = new BaseBall[N];

        for(int i=0; i<N; i++) {
			box[i] = new BaseBall(br.readLine().split(" "));
		}

        int answer = 0;
        for(int i=123; i<=789; i++) {

        	String temp = String.valueOf(i);
        	String[] allNumArr = temp.split("");

        	int s1 = Integer.parseInt(allNumArr[0]);
        	int s2 = Integer.parseInt(allNumArr[1]);
        	int s3 = Integer.parseInt(allNumArr[2]);

        	if(s1 == s2 || s1 == s3 || s2 == s3 ||
					(s1 == 0 || s2 == 0 || s3 ==0)) {
        		continue;
			}

        	if(check(allNumArr)) {
        		answer++;
			}
		}


		bw.write(answer+"");
		bw.flush();
	}

	private static boolean check(String[] allNumArr) {

    	return true;
	}


	private static class BaseBall {
    	int[] number = new int[3];
    	int strike = 0;
    	int ball = 0;

		public BaseBall(String[] input) {
			this.strike = Integer.parseInt(input[1]);
			this.ball = Integer.parseInt(input[2]);

			String[] temp = input[0].split("");
			for(int i=0; i<3; i++) {
				number[i] = Integer.parseInt(temp[i]);
			}
		}
	}
}

