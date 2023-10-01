package com.codingtest.practice.baekjoon.Algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n9019 {

	static int A,T, B;
	static String ans[] = new String[4];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		String res = bfs();
		if(res.equals("FAIL")) System.out.println("ANG");
		else System.out.println(res);

		/*int intres = intbfs();
		if(intres == -1) System.out.println("fail");
		else System.out.println(intres);*/

		/*String s  = "0001";
		int num = Integer.parseInt(s);
		System.out.println("num:"+num);*/


	}

    public static class DSLR {
		int value;
		String register;

		public DSLR(int value, String register) {
			this.value=value;
			this.register=register;
		}
	}

	private static String bfs() {
		boolean chk[] = new boolean[100000];
		//Queue<int[]> q = new LinkedList<>();
		Queue<DSLR> q = new LinkedList<>();
		//q.offer(new int[]{A,0});
        q.offer(new DSLR(A,""));
		chk[A] = true;

		while(!q.isEmpty()) {
			//int num[] = q.poll();
            DSLR dslr = q.poll();

			//int n = num[0];
            int n = dslr.value;
			//int t = num[1];
            String t = dslr.register;

			if(n == B) return t;

			// D
			int tmp = n*2;
			if(tmp > 9999) {
				tmp %= 100000;
			}

			if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
				chk[tmp] = true;
				//q.offer(new int[] {tmp, t+1});
                System.out.println("D에서 t:"+dslr.register);
                System.out.println("D에서 이어붙였던t:"+t);
				q.offer(new DSLR(tmp, t+"D"));
			}

			// S
			tmp = n - 1;
			if( n == 0) {
				tmp = 9999;
			}
			if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
				chk[tmp] = true;
				//q.offer(new int[] {tmp, t+1});
                System.out.println("S에서 t:"+dslr.register);
                System.out.println("S에서 이어붙였던t:"+t);
				q.offer(new DSLR(tmp, t+"S"));
			}

			//L
			tmp = n;
			String s = String.valueOf(tmp);
			String s2 = "";
			if(s.length() > 1) {
				for(int i=1; i<s.length(); i++) {
					s2 += s.charAt(i) - '0';
				}
				s2 += s.charAt(0) - '0';
			}
			if(s2 == "") {
				tmp = 0;
			} else {
				tmp = Integer.parseInt(s2);
			}
			if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
				chk[tmp] = true;
				//q.offer(new int[] {tmp, t+1});
                System.out.println("L에서 t:"+dslr.register);
                System.out.println("L에서 이어붙였던t:"+t);
				q.offer(new DSLR(tmp, t+"L"));
			}

			//R
			tmp = n;
			s = String.valueOf(tmp);
			s2 = "";
			s2 += s.charAt(s.length() - 1) - '0';
			for(int i=0; i<s.length() - 1; i++) {
				s2 += s.charAt(i) - '0';
			}
			if(s2 == "") {
				tmp = 0;
			} else {
				tmp = Integer.parseInt(s2);
			}
			if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
				chk[tmp] = true;
				//q.offer(new int[] {tmp, t+1});
                System.out.println("R에서 t:"+dslr.register);
                System.out.println("R에서 이어붙였던t:"+t);
				q.offer(new DSLR(tmp, t+"R"));
			}
		}
		return "FAIL";
	}

    private static int intbfs() {
        boolean chk[] = new boolean[100000];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{A,0});
        chk[A] = true;

        while(!q.isEmpty()) {
            int num[] = q.poll();

            int n = num[0];
            int t = num[1];

            if(n == B) return t;

            // D
            int tmp = n*2;
            if(tmp > 9999) {
                tmp %= 100000;
            }

            if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
                chk[tmp] = true;
                System.out.println("D에서의 t:"+t);
                q.offer(new int[] {tmp, t+1});
             }

            // S
            tmp = n - 1;
            if( n == 0) {
                tmp = 9999;
            }
            if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
                chk[tmp] = true;
                System.out.println("S에서의 t:"+t);
                q.offer(new int[] {tmp, t+1});
            }

            //L
            tmp = n;
            String s = String.valueOf(tmp);
            String s2 = "";
            if(s.length() > 1) {
                for(int i=1; i<s.length(); i++) {
                    s2 += s.charAt(i) - '0';
                }
                s2 += s.charAt(0) - '0';
            }
            if(s2 == "") {
                tmp = 0;
            } else {
                tmp = Integer.parseInt(s2);
            }
            if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
                chk[tmp] = true;
                System.out.println("L에서의 t:"+t);
                q.offer(new int[] {tmp, t+1});
            }

            //R
            tmp = n;
            s = String.valueOf(tmp);
            s2 = "";
            s2 += s.charAt(s.length() - 1) - '0';
            for(int i=0; i<s.length() - 1; i++) {
                s2 += s.charAt(i) - '0';
            }
            if(s2 == "") {
                tmp = 0;
            } else {
                tmp = Integer.parseInt(s2);
            }
            if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
                chk[tmp] = true;
                System.out.println("R에서의 t:"+t);
                q.offer(new int[] {tmp, t+1});
            }
        }
        return -1;
    }


}

