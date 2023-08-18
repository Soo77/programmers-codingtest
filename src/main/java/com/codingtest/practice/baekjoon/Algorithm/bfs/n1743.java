import java.io.*;
import java.util.*;

public class n1743 {

	static int N,M,K;
	static int map[][];
	static boolean visited[][];
 	static int dx[] = {0,0,1,-1};
	static int dy[] = {-1,1,0,0};
 	static int count = 0;
	static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
 		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
 		for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
 				map[x][y] = 1;
		}
 		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					count = 0;
					bfs(i,j);
					max = Math.max(max, count);
				}
			}
		}

		bw.write(max+"");
		bw.flush();
	}
 	private static void bfs(int startX, int startY) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[]{startX, startY});
		visited[startX][startY] = true;
 		count++;
 		while(!que.isEmpty()) {
			int[] now = que.poll();
			int nowX = now[0];
			int nowY = now[1];
 			for(int i=0; i<4; i++) {	
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
 				if(nextX <= 0 || nextX > N || nextY <= 0 || nextY > M) {
					continue;
				}
 				if(map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
					que.add(new int[]{nextX, nextY});
					visited[nextX][nextY] = true;
					count++;
				}
			}
		}
	}



}
