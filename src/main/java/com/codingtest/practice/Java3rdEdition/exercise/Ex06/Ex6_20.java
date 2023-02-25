package com.codingtest.practice.Java3rdEdition.exercise.Ex06;

public class Ex6_20 {
    public static void main(String[] args) {

        int[] original =null;
        System.out.println(java.util.Arrays.toString(original));
        int[] result = shuffle(original);
        System.out.println(java.util.Arrays.toString(result));

    }

    private static int[] shuffle(int[] arr) {
        if(arr == null || arr.length == 0) {
            return arr;
        }

        for(int i=0; i<arr.length; i++) {
            int j = (int)(Math.random()*arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}
