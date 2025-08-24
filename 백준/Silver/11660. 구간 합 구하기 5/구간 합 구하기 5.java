import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] map = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + map[i][j] - dp[i-1][j-1];
            }
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");

            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            int res = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
            bw.write(res+"\n");
        }

        bw.flush();

    }
}