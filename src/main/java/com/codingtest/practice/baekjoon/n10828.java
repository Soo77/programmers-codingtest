package com.codingtest.practice.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class n10828 {

    public static void main(String[] args) {
        //stack 문제
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> answerList = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.startsWith("push")) {
                int num = sc.nextInt();
                stack.push(num);
                continue;
            } else if (s.startsWith("top")) {
                if (!stack.empty()) {
                    int num = stack.peek();
                    answerList.add(num);
                } else {
                    answerList.add(-1);
                }
                continue;
            } else if (s.startsWith("size")) {
                int size = stack.size();
                answerList.add(size);
                continue;
            } else if (s.startsWith("empty")) {
                if (stack.empty()) {
                    answerList.add(1);
                } else {
                    answerList.add(0);
                }
                continue;
            } else if (s.startsWith("pop")) {
                if (!stack.empty()) {
                    int num = stack.peek();
                    answerList.add(num);
                    stack.pop();
                } else {
                    answerList.add(-1);
                }
                continue;
            }

        }

        for(Integer i : answerList) {
            System.out.println(i);
        }
    }
}