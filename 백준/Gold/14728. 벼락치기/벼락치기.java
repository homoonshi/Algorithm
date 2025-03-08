
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]);

        int[] K = new int[N+1];
        int[] S = new int[N+1];

        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            K[i] = Integer.parseInt(input[0]);
            S[i] = Integer.parseInt(input[1]);
        }

        long[][] dp = new long[N+1][T+1];

        Set<Integer> times = new HashSet<>();
        times.add(T);
        Set<Integer> newTime = new HashSet<>();

        for(int n=1; n<N; n++){
            newTime.clear();
            for (Integer time : times) {
                dp[n][time] = Math.max(dp[n][time], dp[n-1][time]);
                if(time-K[n]>=0){
                    dp[n][time-K[n]] = Math.max(dp[n][time-K[n]], dp[n-1][time] + S[n]);
                    newTime.add(time-K[n]);
                }
            }
            for (Integer time : newTime) {
                times.add(time);
            }
        }

        long result = 0;

        for (Integer time : times) {
            dp[N][time] = Math.max(dp[N][time], dp[N-1][time]);
            result = Math.max(result, dp[N][time]);
            if(time-K[N]>=0){
                dp[N][time-K[N]] = Math.max(dp[N][time-K[N]], dp[N-1][time] + S[N]);
                result = Math.max(result, dp[N][time-K[N]]);
            }
        }

        bw.write(result+"");
        bw.flush();

    }

}
