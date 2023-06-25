package com.codingtest.practice.baekjoon.Algorithm.exhaustive_search;
import java.io.*;
import java.util.StringTokenizer;

//DP
public class n17484 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int fuel[][] = new int[row][col];
        for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
        	for(int j=0; j<col; j++) {
        		fuel[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		int minVal = Integer.MAX_VALUE;
		for(int i=0; i<=col; i++) {
			int result = 0;

			if(minVal > result) {
				minVal = result;
			}
		}

		bw.write(minVal + "");
		bw.flush();
	}


       
}

