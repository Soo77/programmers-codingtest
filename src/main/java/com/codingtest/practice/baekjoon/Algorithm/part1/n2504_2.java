package com.codingtest.practice.baekjoon.Algorithm.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n2504_2 {

    // 괄호의 값
    // 괄호의값 다시해보기

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;

        for(int i=0; i<N.length(); i++) {
            if(N.charAt(i) == '(') {
                stack.push(N.charAt(i));
                value *= 2;
                System.out.print("\nresult="+result+", value="+value);
                if(!stack.isEmpty()) System.out.println(", stack: "+stack.peek());
            } else if(N.charAt(i)=='[') {
                stack.push(N.charAt(i));
                value *= 3;
                System.out.print("\nresult="+result+", value="+value);
                if(!stack.isEmpty()) System.out.println(", stack: "+stack.peek());
            } else if(N.charAt(i)== ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if (N.charAt(i - 1) == '(') {
                    System.out.println(result +"와 "+value+"를 더해서" + (result+value) +"가 되었습니다.1");
                    result += value;

                }
                stack.pop();
                value /= 2;
                System.out.print("\nresult="+result+", value="+value);
                if(!stack.isEmpty()) System.out.println(", stack: "+stack.peek());
            } else if(N.charAt(i)==']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (N.charAt(i-1)=='[') {
                    System.out.println(result +"와 "+value+"를 더해서" + (result+value) +"가 되었습니다.2");
                    result += value;

                } else {
                    System.out.println("둘다아님");
                }
                stack.pop();
                value /= 3;
                System.out.print("\nresult="+result+", value="+value);
                if(!stack.isEmpty()) System.out.println(", stack: "+stack.peek());
            }
        }

        System.out.println();
        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(result);



    }
}
