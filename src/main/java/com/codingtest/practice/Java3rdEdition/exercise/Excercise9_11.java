package com.codingtest.practice.Java3rdEdition.exercise;

/*
* 커맨드라인으로 2~9사이의 두 개의 숫자를 받아서 두 숫자사이의 구구단을 출력하는 프로그램을 작성하시오.
* 예를 들어 3과 5를 입력하면 3단부터 5단까지 출력한다
 * */
public class Excercise9_11 {

    public static void main(String[] args) {

        int from = 0;
        int to = 0;

        try {
            if(args.length!=2)
                throw new Exception("시작 단과 끝 단, 두 개의 정수를 입력해주세요.");

            from = Integer.parseInt(args[0]);
            to = Integer.parseInt(args[1]);

            if(!(2<=from && from <=9 && 2<=to && to<=9))
                throw new Exception("단의 범위는 2와 9사이의 값이어야 합니다.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("USAGE : GugudanTest 3 5");
            System.exit(0);
        }

        if(from > to) {
            int tmp = from;
            from = to;
            to = tmp;
        }

        for(int i=from; i<=to; i++) {
            for(int j=1; j<=9; j++) {
                System.out.println(i+"*"+j+"="+i*j);
            }
            System.out.println();
        }

    }


}
