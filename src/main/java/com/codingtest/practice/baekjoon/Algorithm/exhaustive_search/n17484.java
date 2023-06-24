package com.codingtest.practice.baekjoon.Algorithm.exhaustive_search;
import java.io.*;
import java.util.StringTokenizer;

public class n17484 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        for(int i=0; i<row; i++) {
        	st = new StringTokenizer(br.readLine());

		}
		String[] chess = new String[row];
        for(int i=0; i<row; i++) {
            chess[i] = br.readLine();
        }

		int minVal = Integer.MAX_VALUE;
		for(int i=0; i<=row-8; i++) {
			for(int j=0; j<=col-8; j++) {
				int result = findMinVal(i, j, chess);

				if(minVal > result) {
					minVal = result;
				}
			}
		}

		bw.write(minVal + "");
		bw.flush();
	}

	private static int findMinVal(int startRow, int startCol, String[] chess) {
		String[] orgChess = {"WBWBWBWB", "BWBWBWBW"};
		int Wcount = 0;
		for(int row=startRow; row<startRow + 8; row++) {
			for(int col=startCol; col<startCol + 8; col++) {
				if(chess[row].charAt(col) != orgChess[row%2].charAt(col%8)) {
					Wcount++;
				}
			}
		}

		return Math.min(Wcount, 64 - Wcount);
	}

       
}

