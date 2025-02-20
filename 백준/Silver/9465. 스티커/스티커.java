
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case=0; test_case<T; test_case++){

            int n = Integer.parseInt(br.readLine());

            int[][][] dp = new int[3][3][n+1];
            int[][] map = new int[3][n+1];

            for(int i=1; i<=2; i++){
                String[] input = br.readLine().split(" ");
                for(int j=1; j<=n; j++){
                    map[i][j] = Integer.parseInt(input[j-1]);
                }
            }

            for(int j=1; j<=n; j++){
                for(int i=1; i<=2; i++){

                    if(i==1){
                        dp[0][i][j] = 0;
                        dp[1][i][j] = map[i][j];
                        continue;
                    }

                    int left = Math.max(dp[0][i][j-1], dp[2][i][j-1]);
                    dp[1][i][j] = left + dp[1][i-1][j];

                    left = Math.max(left, dp[1][i][j-1]);
                    dp[0][i][j] = left;

                    left = Math.max(dp[0][i][j-1],dp[1][i][j-1]);
                    dp[2][i][j] = left + map[i][j];

                }
            }

            int max = Math.max(dp[0][2][n], dp[1][2][n]);
            max = Math.max(max, dp[2][2][n]);
            bw.write(max+"\n");

        }

        bw.flush();

    }

}
