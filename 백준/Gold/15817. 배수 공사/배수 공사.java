import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);

        int[][] pipe = new int[N][2];

        for(int i=0; i<N; i++){

            input = br.readLine().split(" ");

            pipe[i][0] = Integer.parseInt(input[0]);
            pipe[i][1] = Integer.parseInt(input[1]);

        }

        int[][] dp = new int[N+1][x+1];

        for(int i=1; i<=N; i++){

            int len = pipe[i-1][0];
            int count = pipe[i-1][1];

            for(int j=1; j<=x; j++){
                dp[i][j] += dp[i-1][j];
                if(dp[i-1][j]>0) {
                    for (int k = 1; k <= count; k++) {
                        if(j + len*k <= x){
                            dp[i][j+len*k] += dp[i-1][j];
                            continue;
                        }
                        break;
                    }
                }
            }

            for(int j=1; j<=count; j++){
                if(len*j<=x) {
                    dp[i][len * j]++;
                    continue;
                }
                break;
            }

        }

        bw.write(dp[N][x]+"");
        bw.flush();

    }
}