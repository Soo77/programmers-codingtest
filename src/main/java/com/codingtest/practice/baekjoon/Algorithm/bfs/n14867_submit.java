package com.codingtest.practice.baekjoon.Algorithm.bfs;

import java.io.*;
import java.util.*;

public class n14867_submit {

	static int A, B, resultA, resultB;

	static String ans[] = new String[4];

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        resultA = Integer.parseInt(st.nextToken());
        resultB = Integer.parseInt(st.nextToken());

		int res = bfs();
		System.out.println(res);


	}


	private static int bfs() {
		Queue<Pair> q = new LinkedList<>();
		HashSet<Pair> visited = new HashSet<>();
		q.add(new Pair(0,0,0));
		visited.add(new Pair(0,0,0));

		while(!q.isEmpty()) {
			Pair tmp = q.poll();
			int a = tmp.a;
			int b = tmp.b;
			int cnt = tmp.cnt;

			if(a== resultA && b == resultB) return cnt;

			// F(a)
			if(a < A) {
				Pair p = new Pair(A, b, cnt+1);

				if(!visited.contains(p)) {
					visited.add(p);
					q.add(p);
				}
			}

			// F(b)
			if(b < B) {
				Pair p = new Pair(a, B, cnt+1);

				if(!visited.contains(p)) {
					visited.add(p);
					q.add(p);
				}
			}

			// E(a)
			if(a > 0) {
				Pair p = new Pair(0, b, cnt+1);

				if(!visited.contains(p)) {
					visited.add(p);
					q.add(p);
				}
			}

			// E(b)
			if(b > 0) {
				Pair p = new Pair(a, 0, cnt+1);

				if(!visited.contains(p)) {
					visited.add(p);
					q.add(p);
				}
			}

			// M(b,a)
			if(a+b <= A) {
				Pair p = new Pair(a+b, 0, cnt+1);

				if(!visited.contains(p)) {
					visited.add(p);
					q.add(p);
				}
			} else { // a+b > A
				Pair p = new Pair(A, a+b - A, cnt+1);

				if(!visited.contains(p)) {
					visited.add(p);
					q.add(p);
				}
			}

			// M(a,b)
			if(a+b <= B) {
				Pair p = new Pair(0, a+b, cnt+1);

				if(!visited.contains(p)) {
					visited.add(p);
					q.add(p);
				}
			} else { // a+b > B
				Pair p = new Pair(a+b-B, B, cnt+1);

				if(!visited.contains(p)) {
					visited.add(p);
					q.add(p);
				}
			}
		}
		return -1;
	}

	public static class Pair {
		int a;
		int b;
		int cnt;

		public Pair(int a, int b, int cnt) {
			this.a = a;
			this.b = b;
			this.cnt = cnt;
		}

		@Override
		public boolean equals(Object o) {
			Pair p = (Pair) o;
			boolean result = (p.a == this.a && p.b == this.b);
			System.out.println("equals함수에서 Pair 객체 출력 >> "+p.toString() + ", result:"+result);
			return result;
		}

		@Override
		public int hashCode() {
			int result = Objects.hash(a, b);
			System.out.println("hash("+a+","+b+ ") >> "+result);
			return result;
		}

		@Override
		public String toString() {
			return "Pair{" +
					"a=" + a +
					", b=" + b +
					", cnt=" + cnt +
					'}';
		}

		/*
		* hash(0,0) >> 961
hash(3,0) >> 1054
hash(3,0) >> 1054
hash(0,5) >> 966
hash(0,5) >> 966
hash(0,0) >> 961
		* */


	}
}

