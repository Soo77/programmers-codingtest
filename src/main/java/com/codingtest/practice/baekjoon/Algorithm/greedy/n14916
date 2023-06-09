import java.io.*;

public class n14916 {
    public static void main(String[] args) throws IOException {
        int n = 0;
        int count = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(bf.readLine());
        
        int fiveMax = n/5;
        for(int i=fiveMax; i>=0; i--) {
            int num = n - (5*i);
            if(num%2 == 0) {
                count = i;
                count += num / 2;
                break;
            }
        }
        
        if(count == 0) {
            count = -1;
        }
        
        bw.write(String.valueOf(count));
        bw.flush();
    }
}
