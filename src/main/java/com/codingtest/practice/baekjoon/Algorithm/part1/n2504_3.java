package com.codingtest.practice.baekjoon.Algorithm.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n2504_3 {

    // 괄호의 값
    // 괄호의값 다시해보기

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        char[] N = br.readLine().toCharArray();

        int result = 0;
        int value = 1;

        for(int i=0; i<N.length; i++) {
            if(N[i] == '(') {
                stack.push(N[i]);
                value *= 2;
            } else if(N[i] == '[') {
                stack.push(N[i]);
                value *= 3;
            } else if(N[i] == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if(N[i-1] == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
            } else if(N[i] == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if(N[i-1] == '[') {
                    result += value;

                }
                stack.pop();
                value /= 3;
            }
           //System.out.println(i+"번재:"+"result 와 value"+result+","+value + "stack?:"+stack.isEmpty());

        }
        //System.out.println(result);
        if(!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }

    }
}
