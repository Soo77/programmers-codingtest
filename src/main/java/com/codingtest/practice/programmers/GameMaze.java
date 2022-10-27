package com.codingtest.practice.programmers;



import java.util.*;

//프로그래머스
//코딩테스트 연습   >  깊이/너비 우선 탐색(DFS/BFS)   >   게임 맵 최단거리
//https://school.programmers.co.kr/learn/courses/30/lessons/1844
//혼자 풀어보기

public class GameMaze {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};


    public static int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];

        visited[0][0] = 1;

        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];

        if(answer == 0) {
            answer = -1;
        }
        return answer;
    }

    public static void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        int cnt= 0;
        while(!q.isEmpty()) {
            cnt++;
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            System.out.println("----------------------------------");
            System.out.println(cnt+") x:"+x+",y:"+y);

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx > maps.length-1 || ny < 0 || ny > maps[0].length-1) {
                    System.out.println(nx+","+ny+"는 저희와 함께할수없습니다.");
                    continue;
                }

                if(visited[nx][ny] == 0 && maps[x][y] ==1 ){
                    System.out.println("visited"+nx+","+ny+"에 방문표시를 할겁니다.");
                    visited[nx][ny] = visited[x][y] + 1;
                    System.out.println("visited"+x+","+y+"("+visited[x][y]+")에 1을 더한 값을 표시해줍니다.");
                    System.out.println("visited[nx][ny](visited"+nx+","+ny+")값은 "+visited[nx][ny]+"가 됩니다.");
                    System.out.println();
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println("답은:"+solution(maps));
        //System.out.println("답2은:"+solution(maps2));

    }

}
