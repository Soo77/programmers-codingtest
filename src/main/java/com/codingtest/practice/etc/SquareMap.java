package com.codingtest.practice.etc;

import java.util.Arrays;

//이코테2021 따라하기
//그리디 알고리즘 예시
//상하좌우
public class SquareMap {

    public static int[] squareMap(int N, String[] move) {

        String[] result = {};

        int[][] map = new int[N+1][N+1];

        System.out.println("map:"+Arrays.deepToString(map));

        int[] point = new int[2];
        point[0]=1;
        point[1]=1;
        for(int i=0; i<move.length; i++) {
            if(move[i].equals("L")) {
                if(point[1] > 1) {
                    point[0]--;
                }
            } else if(move[i].equals("R")) {
                if(point[0] < 5) {
                    System.out.println("R");
                    point[1]++;
                }
            } else if(move[i].equals("U")) {
                if(point[0] > 1) {
                    System.out.println("U");
                    point[0]--;
                }
            } else if(move[i].equals("D")) {
                if(point[0] < 5) {
                    System.out.println("D");
                    point[0] ++;
                }
            }
            System.out.println(point[0]+","+point[1]);
        }


        return point;
    }

    public static void main(String[] args) {

        int N = 5;
        String[] move = {"R","R","R","U","D","D"};

        int[] result = squareMap(N, move);
        System.out.println("result:"+Arrays.toString(result));
    }
}
