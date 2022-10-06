package com.codingtest.practice.baekjoon;

import java.util.*;

public class n7785 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String,String> lastRecord = new HashMap<>();
        int n = sc.nextInt();
        for(int i =0; i<n; i++) {
            String name = sc.next();
            String record = sc.next();
            lastRecord.put(name,record);
        }

        List<String> answerList = new ArrayList<>();
        lastRecord.forEach((key,value) -> {
            if(value.equals("enter")) {
                answerList.add(key);
            }
        });

        Collections.sort(answerList, Collections.reverseOrder());
        for(String name : answerList) {
            System.out.println(name);
        }

    }
}
