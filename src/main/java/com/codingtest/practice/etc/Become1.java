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
        int result = 0;

        while(true) {
            // 25/3 * 3 = 24
            int target = (n/k)*k;
            System.out.println("target:"+target);
            System.out.println("n-target="+(n-target)+"=result");
            result += (n-target);
            System.out.println("result에 "+(n-target)+"을 더합니다. 누적:"+result);
            n = target;
            System.out.println("n이 누군데:"+n);

            if(n<k) {System.out.println("result:"+result); break;}
            result += 1;
            System.out.println("result에 1을 더합니다. 누적:"+result);
            System.out.println("n/k="+n/k);
            n = n/k;


        }
        result += (n-1);
        return result;

    }

    public static int becomeOne3(int n, int k) {
        //스스로 해보기
        int result = 0;
        while(true) {
            // n이 k로 나누어떨어지지 않을때 "가장 가까운 k로 나누어떨어지는 수"를 찾아 target에 담는다.
            int target = (n/k)*k;
            result += (n - target); //1을 빼는 연산을 한번에 수행하도록 n에서 target을 뺀 수를 result에 더함.
            n = target; //n이 target이 될수있도록 담음.
            if(n==0) result-=1; //n이 1이 될때까지의 연산이므로 0이 되었으면 연산한 횟수에서 1을 뺌.
            if(n<k) break;
            result += 1; //n을 k로 나눌때 연산횟수 1 더함
            n /= k;
        }

        return result;
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
        System.out.println("becomeOne:"+result2);

        //int result3 = becomeOne2(a,b);
        //System.out.println(result3);

        int result4 = becomeOne3(a,b);
        System.out.println("result4:"+result4);



    }
}
