package com.codingtest.practice.Java3rdEdition.exercise.Ex10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Excercise10_4 {
    //2009-12-12
    //2009/12/12

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);

        while(!sc.equals(0)) {
            System.out.print("날짜를 yyyy/MM/dd의 형태로 입력해주세요>");
            String data = sc.next();
            //System.out.println("입력값:"+data);

            try {

                SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                Date d = df.parse(data);
                System.out.println(new SimpleDateFormat(">>yyyy/MM/dd \n입력하신 날짜는 E요일입니다.").format(d));


            } catch(Exception e) {
                System.out.println(">>2009/12/12");
            }


        }*/

        String pattern = "yyyy/MM/dd";
        String pattern2 = "입력하신 날짜는 E요일입니다.";

        DateFormat df = new SimpleDateFormat(pattern);
        DateFormat df2 = new SimpleDateFormat(pattern2);

        Scanner sc = new Scanner(System.in);
        Date inDate = null;

        do {
            System.out.println("날짜를 "+pattern +"의 형태로 입력해주세요.(2000/01/01)");
            try {
                System.out.print(">>");
                inDate = df.parse(sc.nextLine());
                break;
            } catch(Exception e) {}
        } while(true);
        System.out.println(df2.format(inDate));

    }
}
