package com.codingtest.practice.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class n10828_2 {

    public static void main(String[] args) {
        //stack 문제
        Stack<Integer> stack = new Stack<Integer>();
        List<String> commandList = new ArrayList<>();
        List<Integer> answerList = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.startsWith("push")) {
                int num = sc.nextInt();
                commandList.add(s+" "+num);
            } else {
                commandList.add(s);
            }
        }

        for(int i=0; i<n; i++) {
            switch (commandList.get(i)) {
                case "top" :
                    System.out.println(commandList.get(i));
                    if (!stack.empty()) {
                        int num = stack.peek();
                        answerList.add(num);
                    } else {
                        answerList.add(-1);
                    }
                case "size" :
                    int size = stack.size();
                    answerList.add(size);
                case "pop" :
                    if (!stack.empty()) {
                        int num = stack.peek();
                        answerList.add(num);
                        stack.pop();
                    } else {
                        answerList.add(-1);
                    }
                default :

                    //int num = Integer.parseInt(commandList.get(i).split(" ")[1]);
                    System.out.println(commandList.get(i)+"몰까요");
                    //stack.push(num);
            }
        }

        for(String i : commandList) {
            System.out.println(i);
        }

        for(Integer i : answerList) {
            System.out.println(i);
        }
    }
}