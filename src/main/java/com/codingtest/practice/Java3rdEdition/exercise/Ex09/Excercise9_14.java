package com.codingtest.practice.Java3rdEdition.exercise.Ex09;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 화면으로부터 전화번호의 일부를 입력받아 일치하는 전화번호를
* 주어진 문자열 배열에서 찾아서 출력하는 프로그램.
*
*
 * */
public class Excercise9_14 {

    public static void main(String[] args) {
        String[] phoneNumArr = {
                "012-3456-7890",
                "099-1456-7980",
                "088-2346-9870",
                "013-3456-7890"
        };

        ArrayList list = new ArrayList();
        Scanner s = new Scanner(System.in);

        while(true) {
            System.out.print(">>");
            String input = s.nextLine();
            System.out.println("firstInput:"+input);
            input = input.trim();
            System.out.println("input:"+input);

            if(input.equals("")) {
                continue;
            } else if(input.equalsIgnoreCase("Q")) {
                System.exit(0);
            }

            //코드넣기
            String pattern = ".*"+input+".*"; //input을 포함하는 모든 문자열
            Pattern p = Pattern.compile(pattern);

            for(int i=0; i<phoneNumArr.length; i++) {
                String phoneNum = phoneNumArr[i];
                String tmp = phoneNum.replace("-", ""); //phoneNum에서 '-'를 제거

                Matcher m = p.matcher(tmp);
                System.out.println("m:"+m);

                if(m.find()) {  // 패턴과 일치하면, list에 phoneNum을 추가한다.
                    list.add(phoneNum);
                }
            }



            if(list.size() > 0) {
                System.out.println(list);
                list.clear();
            } else {
                System.out.println("일치하는 번호가 없습니다.");
            }
        }


    }


}
