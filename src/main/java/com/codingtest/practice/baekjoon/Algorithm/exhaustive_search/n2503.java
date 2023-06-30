package com.codingtest.practice.baekjoon.Algorithm.exhaustive_search;

import java.io.*;
import java.util.Arrays;

// 숫자 야구
public class n2503 {

	static int N;
	static BaseBall[] box;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
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

    	int[] result = new int[2];

    	for(int i=0; i<N; i++) {
    		int[] boxArr = box[i].number;
			result = new int[2];

    		for(int j=0; j<3; j++) {
    			int allNum = Integer.parseInt(allNumArr[j]);

				for(int k=0; k<3; k++) {
					if(boxArr[k] == allNum) {
						System.out.println(Arrays.toString(boxArr)+","+Arrays.toString(allNumArr));
						System.out.println("@@"+boxArr[k]+","+allNum);
						System.out.println(k+","+j);

						if(k==j) {
							result[0]++;
						} else {
							result[1]++;
						}
					}
				}

			}
			System.out.println("result:"+Arrays.toString(result));
			if(!(box[i].strike == result[0] &&
					box[i].ball == result[1])) {

				return false;
			}
    	}

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
				this.number[i] = Integer.parseInt(temp[i]);
			}
		}
	}
}

