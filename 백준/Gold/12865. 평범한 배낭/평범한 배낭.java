
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] dp = new int[N+1][K+1];
        int[][] item = new int[N+1][2];

        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            item[i][0] = Integer.parseInt(input[0]); // 무게
            item[i][1] = Integer.parseInt(input[1]); // 가치
        }

        for(int i=1; i<=N; i++){
            if(item[i][0]<=K) {
                dp[i][item[i][0]] = item[i][1];
            }
            for(int j=1; j<=K; j++){
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                if(j-item[i][0]>0) {
                    int w = dp[i - 1][j - item[i][0]] + item[i][1];
                    if(dp[i][j]<w){
                        dp[i][j] = w;
                    }
                }
            }
        }

        bw.write(dp[N][K]+"");
        bw.flush();

    }
}