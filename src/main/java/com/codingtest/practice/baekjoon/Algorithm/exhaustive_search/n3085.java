import java.io.*;

public class n3085 {

	static char[][] candy;
    static int N;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
 		candy = new char[N][N];
 		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				candy[i][j] = s.charAt(j);
			}
		}
 		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				swap(i, j, i, j+1);
				search();
				swap(i, j+1, i, j);
			}
		}
 		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N; j++) {
				swap(i, j, i+1, j);
				search();
				swap(i+1, j, i, j);
			}
		}

		bw.write(max+"");
		bw.flush();
	}
 	private static void swap(int x1, int y1, int x2, int y2) {
		char temp = candy[x1][y1];
		candy[x1][y1] = candy[x2][y2];
		candy[x2][y2] = temp;
	}
 	private static void search() {
		for(int i=0; i<N; i++) {
			int count = 1;
			for(int j=0; j<N-1; j++) {
				if(candy[i][j] == candy[i][j+1]) {
					count++;
					max = Math.max(max,count);
				} else {
					count = 1;
				}
			}
		}
 		for(int i=0; i<N; i++) {
			int count = 1;
			for(int j=0; j<N-1; j++) {
				if(candy[j][i] == candy[j+1][i]) {
					count++;
					max = Math.max(max,count);
				} else {
					count = 1;
				}
			}
		}
	}



}