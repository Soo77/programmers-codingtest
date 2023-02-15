package com.codingtest.practice.Java3rdEdition.exercise.Ex06;

public class Ex6_23 {

    public static void main(String[] args)
    {
        int[] data = {3,2,9,4,7};
        System.out.println(java.util.Arrays.toString(data));
        System.out.println("최대값 :"+max(data));
        System.out.println("최대값 :"+max(null));
        System.out.println("최대값 :"+max(new int[]{})); // 0 최대값 크기가 인 배열
    }

    private static int max(int[] arr) {

        if(arr == null || arr.length ==0) return -999999;
        int max = arr[0];
        for(int i=1; i<arr.length; i++) {
            System.out.println(max +"보다" + arr[i]+"가 크면" );
            if(max < arr[i] ) {
                max = arr[i];
            }
        }
        return max;
    }

}
