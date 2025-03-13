
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][N+1];

        dp[1][1] = 1;
        dp[1][0] = 1;

        for(int i=2; i<=N; i++){

            dp[i][1] += dp[i-1][0] + dp[1][1];
            dp[i][0] = dp[i][1];

            if(i-4 > 0) {
                for (int j = 2; j < i - 3; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[j][0];
                    dp[i][0] = Math.max(dp[i][0], dp[i][j]);
                }

                dp[i][i - 3] = dp[i - 3][0] * 2;
                dp[i][0] = Math.max(dp[i][0], dp[i][i - 3]);
            }

        }

        bw.write(dp[N][0]+"");
        bw.flush();

    }

}
