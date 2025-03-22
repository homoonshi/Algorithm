
import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        map = new int[M+1][N+1];

        int L = 0;

        for(int i=1; i<=M; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        int[][] dp = new int[M+1][N+1];

        for(int i=1; i<=M; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j]!=0){
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]) + 1;
                L = Math.max(L, dp[i][j]);
            }
        }

        bw.write(L+"");
        bw.flush();

    }

}
