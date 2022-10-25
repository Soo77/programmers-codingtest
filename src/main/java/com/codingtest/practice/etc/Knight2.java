package com.codingtest.practice.etc;

import java.util.Scanner;

//이코테 따라하기
//그리디 알고리즘 예시
// 왕실의 나이트
// 다시풀어보기
public class Knight2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String startPoint = sc.nextLine();

        int row = startPoint.charAt(1) - '0';
        int col = startPoint.charAt(0) - 'a' + 1;

        System.out.println(startPoint+","+row+","+col);


        int dx[] ={-2,-1,1,2,2,1,-1,-2};
        int dy[] ={1,2,2,1,-1,-2,-2,-1};

        int result = 0;
        for(int i=0; i<8; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if(nextRow >= 1 && nextRow <=8 && nextCol >= 1 && nextRow <= 8) {
                result++;
            }
        }

        System.out.println("result:"+result);

    }
}
