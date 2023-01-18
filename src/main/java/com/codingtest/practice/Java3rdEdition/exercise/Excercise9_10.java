package com.codingtest.practice.Java3rdEdition.exercise;

import java.util.Arrays;

/*
* 주어진 문자열을 지정된 크기의 문자열로 변환한다 나머지 공간은 공백으로 채운다
 * */
public class Excercise9_10 {

    private static String format(String str, int length, int alignment) {

        if(length < str.length()) {
            return str.substring(0,length);
        } else {
            char[] strArr = str.toCharArray();
            char[] c = new char[length];
            for(int i=0; i<c.length; i++) {
                c[i] = (char)(i + '0');
            }
            //System.arraycopy(strArr, 0, c, alignment, str.length());
            System.out.println(Arrays.toString(strArr));
            System.out.println(Arrays.toString(c));
            switch(alignment) {
                case 0 :
                    System.arraycopy(strArr, 0, c, 0, str.length());
                    break;
                case 1 :
                    System.arraycopy(strArr, 0, c, (length-str.length())/2, str.length());
                    break;
                case 2 :
                    System.arraycopy(strArr, 0, c, length-str.length(), str.length());
                    break;
                default:
                    break;
            }
            return new String(c);
        }


    }

    public static void main(String[] args) {
        String str = "가나다";

        System.out.println(format(str,7,0));
        System.out.println(format(str,7,1));
        System.out.println(format(str,7,2));
        System.out.println(format("가나다라",14,1));
    }

}
