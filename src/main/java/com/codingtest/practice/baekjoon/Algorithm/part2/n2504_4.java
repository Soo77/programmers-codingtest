package com.codingtest.practice.baekjoon.Algorithm.part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n2504_4 {

    // 괄호의 값
    // 괄호의값 다시해보기

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        Stack<Character> stack = new Stack<>();

        char[] str = br.readLine().toCharArray();
        System.out.println(str);

        int result = 0;
        int temp = 1;

        loop :
        for(int i=0; i<str.length; i++) {
            char c = str[i];
            switch (c) {

                case '(' :
                    stack.push(c);
                    temp *= 2; break;
                case '[' :
                    stack.push(c);
                    temp *= 3; break;
                case ')' :
                    if(stack.isEmpty() || !stack.peek().equals('(')) {
                        result = 0;
                        break loop;
                    } else if(str[i-1] == '('){
                        result += temp;
                    }
                    stack.pop();
                    temp /= 2; break;
                case ']' :
                    if(stack.isEmpty() || !stack.peek().equals('[')) {
                        result = 0;
                        break loop;
                    } else if(str[i-1] == '['){
                        result += temp;
                    }
                    stack.pop();
                    temp /= 3; break;
            }

        }
        if(!stack.isEmpty()) result = 0;
        System.out.println(result);

    }
}
