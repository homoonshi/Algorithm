
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        long[][] dp = new long[N+1][M+1];
        long[][] min = new long[N+1][M+1];
        long[][] max = new long[N+1][M+1];

        int[] orange = new int[N+1];

        for(int i=1; i<=N; i++){
            Arrays.fill(dp[i], Long.MAX_VALUE);
            Arrays.fill(min[i], Long.MAX_VALUE);
            Arrays.fill(max[i], Long.MIN_VALUE);
        }

        for(int i=1; i<=N; i++){
            orange[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp[0], 0);

        for(int i=1; i<=N; i++){

            for(int j=1; j<=M; j++){

                if(i<j){
                    break;
                }

                if(j==1){
                    for(int k=1; k<=M; k++){
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k]);
                    }
                }

                if(j!=1){
                    min[i][j] = min[i-1][j-1];
                    max[i][j] = max[i-1][j-1];
                    dp[i][j] = dp[i-j+1][1] - (K);
                }

                min[i][j] = Math.min(min[i][j], orange[i]);
                max[i][j] = Math.max(max[i][j], orange[i]);

                dp[i][j] += K + j * (max[i][j] - min[i][j]);

            }

        }

        long result = Long.MAX_VALUE;

        for(int i=1; i<=M; i++){
            result = Math.min(result, dp[N][i]);
        }

        bw.write(result+"");
        bw.flush();

    }

}
