package com.codingtest.practice.etc;

import java.util.Scanner;

//이코테 따라하기
//그리디 알고리즘 예시
//곱하기 혹은 더하기
public class MultiOrPlus {

    public static int multiOrPlus(String s) {
        //내가 푼것
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            int s1 = Integer.parseInt(s.split("")[i]);
            //if(result <1 || s1<1) {
            if(result <=1 || s1<=1) { //0뿐만아니라 1까지 포함해야하는것이었다.. 1*1=1, 1+1=2 니까.
                result += s1;
            } else {
                result *= s1;
            }
        }
        return result;
    }
    public static void main(String[] args) {

        String s="02984";
        int result = multiOrPlus(s);
        System.out.println("result:"+result);

        String input = "";
        while(true) {
            System.out.print("숫자를 입력하세옹(-1입력시 종료):");
            Scanner sc = new Scanner(System.in);
            input = sc.next();
            if(input.equals("-1")) {System.out.println("종료.");break;}
            int result2 = multiOrPlus(input);
            System.out.println("result2:"+result2);
        }



    }
}
