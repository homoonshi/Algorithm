
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < T; test_case++){

            int N = Integer.parseInt(br.readLine());

            String[] input = br.readLine().split(" ");
            int[] coin = new int[N];

            for(int i=0; i<N; i++){
                coin[i] = Integer.parseInt(input[i]);
            }

            int M = Integer.parseInt(br.readLine());
            long[] dp = new long[M+1];

            for(int i=0; i<N; i++){

                int currentCoin = coin[i];
                if(currentCoin<=M) {
                    dp[currentCoin]++;
                }

                for(int j=currentCoin; j<=M; j++){

                    dp[j] += dp[j-currentCoin];

                }

            }

            bw.write(dp[M]+"\n");

        }

        bw.flush();

    }

}
