import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N==1){
            bw.write("0");
            bw.flush();
            return;
        }

        long[][] dp = new long[3][N+1];

        dp[0][2] = 1;
        dp[1][2] = 1;

        long div = 1_000_000_007;

        for(int i=3; i<=N; i++){

            dp[0][i] = (dp[2][i-1]+dp[1][i-1])%div;
            dp[1][i] = (dp[0][i-1]+dp[2][i-1])%div;
            dp[2][i] = (dp[1][i-1]+dp[0][i-1])%div;

        }

        bw.write(dp[0][N]+"");
        bw.flush();

    }
}