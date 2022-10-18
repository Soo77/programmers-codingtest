package com.codingtest.practice.etc;

import java.util.Arrays;

//이코테2021 따라하기
//그리디 알고리즘 예시
//상하좌우
public class SquareMap2 {

    public static int[] squareMap(int N, char[] move) {

        int[] result = new int[2];
        result[0] = 1;
        result[1] = 1;

        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        char moveTypes[] = {'L', 'R', 'U', 'D'};

        int x = 0, y = 0;
        for(int i=0; i<move.length; i++) {
            char plan = move[i];
            for(int j=0; j<4; j++) {
                if(plan == moveTypes[j]) {
                    System.out.println("plan:"+plan);
                    x = result[0] + dx[j];
                    y = result[1] + dy[j];
                }

            }
            if(x < 1 || y < 1 || x > N || y > N) continue;
            result[0] = x;
            result[1] = y;

        }

        return result;
    }

    public static void main(String[] args) {

        int N = 5;
        char[] move = {'R','R','R','U','D','D'};

        int[] result = squareMap(N, move);
        System.out.println("result:"+Arrays.toString(result));
    }
}
