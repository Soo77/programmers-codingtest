package com.codingtest.practice.Java3rdEdition.exercise.Ex08;

import java.util.Scanner;

/* 8-1
* 예외처리의 정의와 목적?
* >> 정의: 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한
*    코드를 작성하는 것
*    목적: 프로그램의 비정상 종료를 막고, 정상적인 실행상태를
*    유지하는 것
*
*    에러(error): 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
*    예외(exception): 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류
*
*   8-2
*   d
*
*   8-3
*   d,e
*
*   8-4
*   c
*
*   8-5
*   1 3 5
*   1 2 5 6
*
*   8-6
*   3 5
*
*   8-7
*   1
*   System.exit(0)이 수행되어 프로그램 즉시 종료.
*   finally블럭 수행되지 X
*
*
*
*
* */
public class Ex8_1 {
    public static void main(String[] args)
    {
// 1~100 answer . 사이의 임의의 값을 얻어서 에 저장한다
        int answer = (int)(Math.random() * 100) + 1;
        int input = 0; // 사용자입력을 저장할 공간
        int count = 0; // 시도횟수를 세기 위한 변수
        do {
            count++;
            System.out.print("1과 100 사이의 값을 입력하세요   :");

            try {
                input = new Scanner(System.in).nextInt();
            } catch(Exception e) {
                System.out.println("유효하지 않은 값입니다. " +
                        "다시 값을 입력해주세요.");
                continue;
            }


            if(answer > input) {
                System.out.println(" 더 큰 수를 입력하세요.");
            } else if(answer < input) {
                System.out.println(" 더 작은 수를 입력하세요.");
            } else {
                System.out.println("맞췄습니다 .");
                System.out.println("시도횟수는 "+count+" 번입니다 .");
                break; // do-while문을 벗어난다
            }
        } while(true); // 무한반복문
    } // end of main
}
