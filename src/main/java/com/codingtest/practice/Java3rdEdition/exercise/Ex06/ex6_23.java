package com.codingtest.practice.Java3rdEdition.exercise.Ex06;

import java.util.Arrays;

public class ex6_23 {

    private static int max(int[] arr) {
        if(arr == null || arr.length==0) return -999999;

        int temp = arr[0];
        for(int i=1; i<arr.length; i++) {

            if(temp < arr[i]) {
                temp = arr[i];
                System.out.println("temp2:"+temp);
            }

        }
        return temp;
    }

    public static void main(String[] args) {
        int[] data = {3,2,9,4,7};
        System.out.println(Arrays.toString(data));
        System.out.println("최대값:"+max(data));
        System.out.println("최대값:"+max(null));
        System.out.println("최대값:"+max(new int[]{}));
    }
}
