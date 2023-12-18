package com.codingtest.practice.baekjoon.Algorithm.random;

import java.io.*;
import java.util.StringTokenizer;

public class n1080 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int arr1[][] = new int[N][M];
		int arr2[][] = new int[N][M];

		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				arr1[i][j] = s.charAt(j) - '0';
			}
		}
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				arr2[i][j] = s.charAt(j) - '0';
			}
		}

		System.out.println("원래");
		System.out.println("arr1");
		for(int t=0; t<N; t++) {
			for(int v=0; v<M; v++) {
				System.out.print(arr1[t][v]+",");
			}
			System.out.println();
		}
		System.out.println("arr2");
		for(int t=0; t<N; t++) {
			for(int v=0; v<M; v++) {
				System.out.print(arr2[t][v]+",");
			}
			System.out.println();
		}

		int answer =0;
		for(int i=0; i<N-2; i++) {
			for(int j=0; j<M-2; j++) {
				if(arr1[i][j] == arr2[i][j]) {
					continue;
				}

				answer ++;
				for(int x=i; x<i+3; x++) {
					for(int y=j; y<j+3; y++) {
						arr1[x][y] = arr1[x][y] == 1 ? 0 : 1;
					}
				}
				System.out.println("변경"+answer+"차");
				System.out.println("arr1");
				for(int t=0; t<N; t++) {
					for(int v=0; v<M; v++) {
						System.out.print(arr1[t][v]+",");
					}
					System.out.println();
				}



			}
		}


		System.out.println("마무으리");
		System.out.println("arr1");
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr1[i][j]+",");
			}
			System.out.println();
		}System.out.println("arr2");
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr2[i][j]+",");
			}
			System.out.println();
		}


	}
}