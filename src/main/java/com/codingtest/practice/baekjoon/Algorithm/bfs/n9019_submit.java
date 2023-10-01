package com.codingtest.practice.baekjoon.Algorithm.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n9019_submit {

	static int A,T, B;
	static String ans[] = new String[4];

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            String res = bfs();
            if (res.equals("FAIL")) System.out.println("FAIL");
            else bw.write(res+"\n");
        }
        bw.flush();
        bw.close();
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
		boolean chk[] = new boolean[10001];
		Queue<DSLR> q = new LinkedList<>();
		q.offer(new DSLR(A,""));
		chk[A] = true;

		while(!q.isEmpty()) {
			DSLR dslr = q.poll();

			int n = dslr.value;
			String t = dslr.register;

			if(n == B) return t;

			// D
			int tmp = n*2;
			if(tmp > 9999) {
				tmp %= 10000;
			}

			if(!chk[tmp]) {
				chk[tmp] = true;
				q.offer(new DSLR(tmp, t+"D"));
			}

			// S
			tmp = (n == 0) ? 9999 : (n - 1);
			if(!chk[tmp]) {
				chk[tmp] = true;
				q.offer(new DSLR(tmp, t+"S"));
			}

			//L
			tmp = (n%1000) * 10 + n/1000;
			if(!chk[tmp]) {
				chk[tmp] = true;
				q.offer(new DSLR(tmp, t+"L"));
			}

			//R
			tmp = n/10 + (n%10) * 1000;
			if(!chk[tmp]) {
				chk[tmp] = true;
				q.offer(new DSLR(tmp, t+"R"));
			}
		}
		return "FAIL";
	}
}

