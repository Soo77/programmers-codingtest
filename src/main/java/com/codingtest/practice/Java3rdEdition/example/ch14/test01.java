package com.codingtest.practice.Java3rdEdition.example.ch14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test01 {
    public static void main(String[] args) {

        int rand = -1;
        int count = 0;
        int[] numArr = new int[101];
        int sum = 0;

        for(int i=0; i<1000; i++){
            count++;
            rand = (int)(Math.random()*100)+1;
            numArr[rand]++;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i=1; i<numArr.length; i++) {
            countMap.put(i, numArr[i]);
        }

        System.out.println("*****For 문*****");
        for(Integer key : countMap.keySet()) {
            Integer value =  countMap.get(key);
            System.out.println(key + " : " + value);
        }

        List<Integer> keySet = new ArrayList<>(countMap.keySet());
        keySet.sort((key, value) -> countMap.get(value).compareTo(countMap.get(key)));

        System.out.println("내림차순 정렬");
        for(Integer key : keySet) {
            System.out.println(key + ":" + countMap.get(key));
        }






    }
}
