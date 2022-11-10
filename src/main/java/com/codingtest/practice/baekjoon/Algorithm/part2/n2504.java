package com.codingtest.practice.baekjoon.Algorithm.part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n2504 {

    // 괄호의 값
    // 괄호의값 다시해보기

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        String input = br.readLine();
        char arr[] = input.toCharArray();
        int ans = 0;
        int tmp = 1;
        for(int i=0; i<arr.length; i++) {
            char c = arr[i];
            if(c=='(' || c=='[') {
                stack.add(c);
                tmp *= (c=='(') ? 2 : 3;
            } else {
                char cc = stack.pop();
                if(c==')') {
                    if(cc != '(') {
                        ans = 0;
                        break;
                    } else {
                        if(arr[i-1] == '(') {
                            ans += tmp;
                        }
                        tmp /= 2;
                    }
                }  else {
                    if(cc != '[') {
                        ans = 0;
                        break;
                    } else {
                        if(arr[i-1] == '[') {
                            ans += tmp;
                        }
                        tmp /= 3;
                    }
                }
            }
        }
        if(!stack.isEmpty())
            ans = 0;
        System.out.println(ans);

    }
}
