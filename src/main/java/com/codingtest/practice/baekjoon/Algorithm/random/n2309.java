package com.codingtest.practice.baekjoon.Algorithm.random;

import java.io.*;
import java.util.Arrays;

public class n2309 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int arr[] = new int[9];
		for(int i=0; i<9; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			sum += num;
		}



		System.out.println(sum);
		System.out.println(Arrays.toString(arr));

		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum - arr[i] - arr[j] == 100) {
					arr[i] = 0;
					arr[j] = 0;

					Arrays.sort(arr);
					for(int k=2; k<9; k++) {
						System.out.println(arr[k]);
					}
					return;

				}
			}
		}
    }
}
