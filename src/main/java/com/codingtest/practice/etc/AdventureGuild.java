package com.codingtest.practice.etc;

import java.util.Arrays;
import java.util.Scanner;

//이코테2021 따라하기
//그리디 알고리즘 예시
//모험가 길드
public class AdventureGuild {

    public static int adventureGuild(int N, String fear) {

        int result = 0; //총그룹수
        int count = 0; //현재 그룹에 포함된 모험가의 수
        int[] members = new int[N];
        for(int i=0; i<N; i++) {
            int member = Integer.parseInt(fear.split(" ")[i]);
            members[i] = member;
        }
        Arrays.sort(members);
        System.out.println(Arrays.toString(members));

        for(int i : members) {
            count+=1;
            if(count >= i) {
                result += 1;
                count = 0;
            }
        }
        return result;
    }

    public static int adventureGuild2(int N, int[] fear) {
        //내가 혼자 따라해보기
        int result = 0;
        int count = 0;

        Arrays.sort(fear);

        System.out.println(Arrays.toString(fear));

        for(int i : fear) {
            count ++;
            if(count >= i) {
                result++;
                count = 0;
            }
        }

        return result;
    }















    public static void main(String[] args) {

        int N = 5;
        String fear = "2 3 1 2 2";
        int[] fear2 = {2, 3, 1, 2, 2};

        int result = adventureGuild(N, fear);
        int result2 = adventureGuild2(N, fear2);
        System.out.println("result:"+result);
        System.out.println("result2:"+result2);
    }
}
