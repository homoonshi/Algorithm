
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        long[][] dp = new long[K+1][N+1];

        Arrays.fill(dp[1], 1);

        for (int i=2; i<=K; i++){
            for(int j=0; j<=N; j++){
                for(int k=j; k<=N; k++){
                    dp[i][k] += dp[i-1][k-j];
                    dp[i][k] %= 1000000000;
                }
            }
        }

        bw.write(dp[K][N]+"");
        bw.flush();

    }

}
