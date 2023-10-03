package com.codingtest.practice.baekjoon.Algorithm.bfs;

import java.io.*;
import java.util.*;

// 물통
/*
* 용량이 다른 두 개의 빈 물통 A, B가 있다.
* 이 물통들에 물을 채우고 비우는 일을 반복하여 두 물통을 원하는 상태(목표하는 양의 물을 담은 상태)
* 가 되도록 만들고자 한다. 물통 이외에는 물의 양을 정확히 잴 수 있는 방법이 없으며
* 가능한 작업은 다음과 같은 세 종류가 전부이다.
* */
public class n14867 {

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

		/*Pair p = new Pair(0,10,3);
		Pair p2 = new Pair(1,3,3);
		System.out.println(p);
		System.out.println(p2);*/

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

		/* equals()를 오버라이딩 하면 hashCode()도 같이 오버라이딩해야한다.
		* equals()의 결과가 true인 두 객체의 해시코드는 같아야하기 때문.
		* */
		@Override
		public boolean equals(Object o) {
			Pair p = (Pair) o;

			return (p.a == this.a && p.b == this.b);
		}

		@Override
		public int hashCode() {
			return (""+a+b).hashCode();
		}

		//com.codingtest.practice.baekjoon.Algorithm.bfs.n14867$Pair@2ef9b8bc
		//com.codingtest.practice.baekjoon.Algorithm.bfs.n14867$Pair@2ef9b8bc
		//com.codingtest.practice.baekjoon.Algorithm.bfs.n14867$Pair@2ef9b8bc

		/* com.codingtest.practice.baekjoon.Algorithm.bfs.n14867$Pair@2ef9b8bc
		com.codingtest.practice.baekjoon.Algorithm.bfs.n14867$Pair@5d624da6
		*/


	}

}

