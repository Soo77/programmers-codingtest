package com.codingtest.practice.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class n10828_3 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        //stack 문제
        Stack<Integer> stack = new Stack<Integer>();
        //Scanner를 사용하면 시간초과가 떠서 구글링해보니
        //BufferedReader, BufferedWriter 사용하라고 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("push")) {
                stack.push(Integer.parseInt(s[1]));
            } else if (s[0].equals("top")) {
                if (!stack.empty()) {
                    bw.write(stack.peek()+"\n");
                } else {
                    bw.write(-1 + "\n");
                }
            } else if (s[0].equals("size")) {
                bw.write(stack.size()+"\n");
            } else if (s[0].equals("empty")) {
                if (stack.empty()) {
                    bw.write(1+"\n");
                } else {
                    bw.write(0+"\n");
                }
            } else if (s[0].equals("pop")) {
                if (!stack.empty()) {
                    bw.write(stack.pop()+"\n");
                } else {
                    bw.write(-1+"\n");
                }
            }

        }
        bw.flush();
    }
}