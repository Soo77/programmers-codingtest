import java.io.*;
import java.util.*;

public class n7576 {


	static int N,M;
	static int box[][];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
 		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
 		box = new int[N][M];
 		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			 for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			 }
		}
 		int result = bfs();
		System.out.println(result);
 	}
 	private static int bfs() {
		Queue<Tomato> que = new LinkedList<>();
		int day = 0;
 		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 1) {
					que.offer(new Tomato(i,j,0));
				}
			}
		}
 		while(!que.isEmpty()) {
			Tomato tomato = que.poll();
			day = tomato.day;
 			for(int i=0; i<4; i++) {
				int nx = tomato.x + dx[i];
				int ny = tomato.y + dy[i];
 				if(nx >= 0 && ny >= 0 && nx < N && ny <M ) {
					if(box[nx][ny] == 0) {
						box[nx][ny] = 1;
						que.add(new Tomato(nx,ny,day+1));
					}
				}
			}
		}
 		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 0) return -1;
			}
		}
 		return day;
	}
 	static class Tomato {
		int x;
		int y;
		int day;
 		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
}
