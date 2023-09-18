import java.io.*;
import java.util.*;

public class n4179 {

		static int N,M,ans;
		static char map[][];
		static Queue<int[]> q;
		static int dx[] = {0,0,-1,1};
		static int dy[] = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		ans = 0;
		map = new char[N][M];
		
		int x = 0, y = 0;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'F') {
					q.add(new int[]{i,j});
				} else if(map[i][j] == 'J') {
					x=i;
					y=j;
				}
			}
		}
		q.add(new int[]{x,y});
		sb.append(bfs() ? ans : "IMPOSSIBLE");
		System.out.println(sb);
	}
	
	private static boolean bfs() {
		while(!q.isEmpty()) {
			ans++;
			for(int i=0, size=q.size(); i<size; i++) {
				int poll[] = q.poll();
				int x = poll[0];
				int y = poll[1];
				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(nx <0 || nx>=N || ny<0 || ny>=M) {
						if(map[x][y] == 'J') {
							return true;
						}
						continue;
					}
					
					if(map[nx][ny] != '.') {
						continue;
					}
					
					q.add(new int[]{nx,ny});
					map[nx][ny] = map[x][y];
				}
			}
		}
		return false;
	}

       
}

