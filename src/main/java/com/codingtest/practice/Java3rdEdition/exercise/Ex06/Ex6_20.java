package com.codingtest.practice.Java3rdEdition.exercise.Ex06;

public class Ex6_20 {


    public static void main(String[] args)
    {
        int[] original = {1,2,3,4,5,6,7,8,9};
        System.out.println(java.util.Arrays.toString(original));
        int[] result = shuffle(original);
        System.out.println(java.util.Arrays.toString(result));
    }

    private static int[] shuffle(int[] arr) {

        if(arr ==null || arr.length == 0) {
            return arr;
        }

        for(int i=0; i<arr.length; i++) {
            int num = (int)(Math.random()*arr.length);
            int tmp = arr[i];
            arr[i] = arr[num];
            arr[num] = tmp;
        }
        return arr;
    }
}
