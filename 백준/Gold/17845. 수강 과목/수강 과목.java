import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] dp = new int[K+1][N+1];

        for(int i=1; i<=K; i++){
            input = br.readLine().split(" ");

            int important = Integer.parseInt(input[0]);
            int study = Integer.parseInt(input[1]);

            if(study<=N) {
                dp[i][study] = important;
            }

            for(int j=1; j<=N; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);

                if(j+study <= N){
                    dp[i][j+study] = dp[i-1][j] + important;
                }
            }
        }

        bw.write(dp[K][N]+"");
        bw.flush();

    }
}
