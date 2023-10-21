package com.codingtest.practice.baekjoon.Algorithm.dp;

import java.io.*;

public class n9655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
  long N = Long.parseLong(br.readLine());
  if(N%2==0) {
   bw.write("CY");
  } else {
   bw.write("SK");
  }
  bw.flush();
  bw.close();
    }
}
