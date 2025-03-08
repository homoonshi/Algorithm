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

        int R = M+1;

        long[][] dp = new long[R][M+1];
        int[][] min = new int[R][M+1];
        int[][] max = new int[R][M+1];

        int[] orange = new int[N+1];

        for(int i=0; i<R; i++){
            Arrays.fill(dp[i], Long.MAX_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
            Arrays.fill(max[i], Integer.MIN_VALUE);
        }

        for(int i=1; i<=N; i++){
            orange[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=N; i++){

            if(i>R) {
                Arrays.fill(dp[i % R], Long.MAX_VALUE);
                Arrays.fill(min[i % R], Integer.MAX_VALUE);
                Arrays.fill(max[i % R], Integer.MIN_VALUE);
            }

            for(int j=1; j<=M; j++){

                if(i<j){
                    break;
                }

                if(j==1){
                    if(i==1){
                        dp[i%R][j] = 0;
                    }
                    for(int k=1; k<=M; k++){
                        dp[i%R][j] = Math.min(dp[i%R][j], dp[(i-1)%R][k]);
                    }
                }

                if(j!=1){
                    min[i%R][j] = min[(i-1)%R][j-1];
                    max[i%R][j] = max[(i-1)%R][j-1];
                    dp[i%R][j] = dp[(i-j+1)%R][1] - (K);
                }

                min[i%R][j] = Math.min(min[i%R][j], orange[i]);
                max[i%R][j] = Math.max(max[i%R][j], orange[i]);

                dp[i%R][j] += K + (long) j * (max[i%R][j] - min[i%R][j]);

            }

        }

        long result = Long.MAX_VALUE;

        for(int i=1; i<=M; i++){
            result = Math.min(result, dp[N%R][i]);
        }

        bw.write(result+"");
        bw.flush();

    }

}
