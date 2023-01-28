package com.codingtest.practice.Java3rdEdition.exercise.Ex09;

/*
* 주어진 문자열을 지정된 크기의 문자열로 변환한다 나머지 공간은 공백으로 채운다
 * */
public class Excercise9_10 {

    private static String format(String str, int length, int alignment) {
        int diff = length - str.length();
        if(diff < 0) return str.substring(0, length);

        char[] strArr = str.toCharArray();
        char[] dest = new char[length];
        for(int i=0; i<dest.length; i++) {
            dest[i] = (char)(i + '0');
        }

        switch (alignment) {
            case 0 :
                System.arraycopy(strArr, 0, dest, 0, str.length());
                break;
            case 1 :
                System.arraycopy(strArr, 0, dest, diff/2, str.length());
                break;
            case 2 :
                System.arraycopy(strArr, 0, dest, diff, str.length());
                break;
        }

        return new String(dest);
    }


    public static void main(String[] args) {
        String str = "가나다";

        System.out.println(format(str,7,0));
        System.out.println(format(str,7,1));
        System.out.println(format(str,7,2));
    }

}
