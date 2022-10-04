package com.codingtest.practice.prac202209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeliveryAndPickup2 {


    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        int count = 0 ;

        for(int i=n-1; i>=0; i--) {
            System.out.print(deliveries[i]+",");
            if(deliveries[i] > 0 && (deliveries[i]+count) <= cap) {
                count += deliveries[i];
                deliveries[i] = 0;
            } else {
                break;
            }
        }


        System.out.println();
        for(Integer i: deliveries) {
            System.out.print(i+",");
        }
        System.out.println();;
        return answer;
    }

    public static void main(String[] args) {

        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        System.out.println();
        System.out.println();
        System.out.println(DeliveryAndPickup2.solution(cap, n, deliveries, pickups));
    }
}
