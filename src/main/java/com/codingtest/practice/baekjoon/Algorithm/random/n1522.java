package com.codingtest.practice.baekjoon.Algorithm.random;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n1522 {
  
  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    String str = br.readLine();
    
    int min = Integer.MAX_VALUE;
    
    int aCnt = 0;
    for(int i=0; i<str.length(); i++) {
      if(str.charAt(i) == 'a') {
        aCnt++;
      }
    }
    
    for(int i=0; i<str.length(); i++) {
      int bCnt = 0;
      for(int j=i; j<i+aCnt; j++) {
        int idx = j%str.length();
        if(str.charAt(idx)=='b') {
          bCnt++;
        }
        
      }
      min = Math.min(min, bCnt);
    }
    System.out.println(min);
  }

 
}
