package com.codingtest.practice.baekjoon.Algorithm.random;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class n20006 {

	private static class Player implements Comparable<Player> {

		int level;
		String name;
		boolean check;

		public Player(int level, String name) {
			this.level = level;
			this.name = name;
		}

		@Override
		public int compareTo(Player p1) {
			return name.compareTo(p1.name);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int p = Integer.parseInt(st.nextToken()); // 플레이어 수
		int m = Integer.parseInt(st.nextToken()); // 방의 정원
		Player[] players = new Player[p];

		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			players[i] = new Player(level, name);
		}

		for(int i=0; i<p; i++) {
			System.out.println("룸새로만듦");
			ArrayList<Player> room = new ArrayList<>();
			if(!players[i].check) {

				for(int j=i; j<p; j++) {
					System.out.println("i:"+i+",j:"+j);
					if(room.size() == m) {
						break;
					}
					int level = players[j].level;
					String name = players[j].name;
					if(!players[j].check
						&& players[i].level - 10 <= level
						&& players[i].level + 10 >= level) {
						players[j].check = true;
						System.out.println(j+"번째 추가할거야 "+name);
						room.add(players[j]);
					}
				}

				Collections.sort(room);
				if(room.size() == m) {
					sb.append("Started!").append("\n");
				} else {
					sb.append("Waiting!").append("\n");
				}
				for(Player player : room) {
					sb.append(player.level).append(" ").append(player.name).append("\n");
				}
			}
		}
		System.out.println(sb);
	}


}