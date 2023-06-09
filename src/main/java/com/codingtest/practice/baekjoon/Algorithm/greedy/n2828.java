package com.codingtest.practice.baekjoon.Algorithm.greedy;

import java.io.*;

public class n2828 {
    public static void main(String[] args) throws IOException {
        int screenSize = 0;
        int boxSize = 0;
        int appleCnt = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = bf.readLine().split(" ");
        screenSize = Integer.parseInt(temp[0]);
        boxSize = Integer.parseInt(temp[1]);
        //System.out.println(screenSize+","+boxSize);

        appleCnt = Integer.parseInt(bf.readLine());
        int position[] = new int[appleCnt];
        for(int i=0; i<appleCnt; i++) {
            position[i] = Integer.parseInt(bf.readLine());
        }

        int mypos = 1;
        int moveCnt = 0;
        for(int i=0; i<appleCnt; i++)  {
            int applePos = position[i];
            if(applePos > mypos + (boxSize-1)) {
                while(true) {
                    mypos++;
                    moveCnt++;
                    if ((mypos + (boxSize - 1)) == applePos) {
                        //System.out.println("1 applePos:"+applePos+", mypos:"+mypos + ", moveCnt:"+moveCnt);
                        break;
                    }
                }
            } else if(applePos < mypos) {
                while(true) {
                    mypos--;
                    moveCnt++;
                    if (mypos == applePos) {
                       // System.out.println("2 applePos:" + applePos + ", mypos:" + mypos + ", moveCnt:" + moveCnt);
                        break;
                    }
                }
            } else {
                //System.out.println("3 applePos:"+applePos+", mypos:"+mypos + ", moveCnt:"+moveCnt);
                continue;
            }

        }
        bw.write(String.valueOf(moveCnt));
        bw.flush();


    }
}
