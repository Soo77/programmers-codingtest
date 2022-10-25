package com.codingtest.practice.etc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//이코테 따라하기
//그리디 알고리즘 예시
// 왕실의 나이트
public class Knight {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String startPoint = sc.nextLine();

        int row = startPoint.charAt(1) - '0';
        int column = startPoint.charAt(0) - 'a' + 1;

        //System.out.println(startPoint+","+row+","+column);
        //(-2,-1) (-1,-2) (1,-2) (2,-1)
        int dx[] = {-2,-1,1,2,2,1,-1,-2};
        int dy[] = {1,2,2,1,-1,-2,-2,-1};

        int result = 0;
        for(int i=0; i<8; i++) {
            int nextRow = row + dx[i];
            int nextCol = row + dy[i];
            if(nextRow >= 1 && nextRow <= 8 && nextCol >= 1 && nextCol <=8) {
                result++;
            }
        }
        System.out.println("결과값:"+result);

    }
}
