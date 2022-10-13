package com.codingtest.practice.etc;

import java.util.Scanner;

//그리디 알고리즘 예시
//1이 될때까지
public class Become1 {

    public static int becomeOne(int n1, int n2) {
        int cnt = 0;
        while(n1!=1) {
            if(n1 % n2 == 0) {
                n1 /= n2;
                cnt ++;
            } else {
                n1 -= 1;
                cnt ++;
            }
        }
        return cnt;
    }

    public static int becomeOne2(int n, int k) {
        int cnt = 0;
        while(true) {
            // n이 k로 나누어 떨어지는 수가 될때까지 빼기
            System.out.println("("+n+"/"+k+")*"+k);
            System.out.println(n/k+"*"+k);
            int target = (n / k) * k ;
            System.out.println("target:"+target);
            System.out.println(n+"-"+target);
            cnt += (n - target);
            n = target;
            // n이 k보다 작을 때(더이상 나눌 수 없을때) 반복문 탈출
            if(n < k) break;
            //k로 나누기
            cnt++;
            n /= k;
        }
        //마지막으로 남은 수에 대하여 1씩 빼기
        cnt += (n - 1);
        return cnt;
    }

    public static void main(String[] args) {


        int n = 17;
        int k = 4;

        int result = becomeOne(n,k);

        System.out.println(result);

        System.out.println("===============1이 될때까지 2탄============================");

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result2 = becomeOne(a,b);
        System.out.println(result2);

        int result3 = becomeOne2(a,b);
        System.out.println(result3);




    }
}
