package com.codingtest.practice.prac202209;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeliveryAndPickup {


    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        int[] checkArr = new int[n];
        List<Integer> findIndexList = new ArrayList<>();

        int delivCnt = 0;
        int pickUpCnt = 0;
        int index = n-1;
        findIndexList.add(index);

        int i=1;
        while(i<7) {

            index = Collections.min(findIndexList);
            while(index > -1) {

                if(delivCnt < cap && deliveries[index] > 0) {
                    deliveries[index]--;
                    delivCnt++;
                    findIndexList.add(index);
                }
                if(pickUpCnt < cap && pickups[index] > 0) {
                    pickups[index]--;
                    pickUpCnt++;
                    findIndexList.add(index);
                }

                index--;
                if(delivCnt == cap && pickUpCnt == cap) break;

            }

            if(Arrays.equals(deliveries,checkArr) && Arrays.equals(pickups, checkArr)) {
                break;
            }

            //if(delivCnt == cap && pickUpCnt == cap) continue;
        }

        return answer;
    }

    public static void main(String[] args) {

        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        System.out.println(DeliveryAndPickup.solution(cap, n, deliveries, pickups));
    }
}
