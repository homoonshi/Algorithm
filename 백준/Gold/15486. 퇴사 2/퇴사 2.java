import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input;
        long[] dp = new long[N+1];
        long res = 0;

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");

            int T = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);

            if(i > 0 && dp[i] < dp[i-1]){
                dp[i] = dp[i-1];
            }

            if(i+T <= N) {
                dp[i + T] = Math.max(dp[i + T], dp[i] + P);
                res = Math.max(res, dp[i+T]);
            }
        }

        bw.write(res+"");
        bw.flush();

    }
}