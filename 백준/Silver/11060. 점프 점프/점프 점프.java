import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=0; i<N; i++){
            if(dp[i]==Integer.MAX_VALUE) continue;
            int jump = Integer.parseInt(input[i]);
            for(int j=1; j<=jump; j++){
                if(i+j >= N) break;
                dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
            }
        }

        if (dp[N-1] == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(dp[N-1] + "");
        }

        bw.flush();

    }
}