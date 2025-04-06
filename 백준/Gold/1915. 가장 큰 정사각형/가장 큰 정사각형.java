
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        int res = 0;

        for(int i=1; i<=n; i++){
            String inp = br.readLine();
            for(int j=1; j<=m; j++){
                map[i][j] = inp.charAt(j-1) - '0';
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j]==1){
                    dp[i][j] = 1;
                    res = Math.max(res, dp[i][j]);
                    if(dp[i-1][j-1]>=1 && dp[i-1][j]>=1 && dp[i][j-1]>=1){
                        int temp = Math.min(dp[i-1][j-1], dp[i-1][j]);
                        temp = Math.min(temp, dp[i][j-1]);
                        dp[i][j] = temp + 1;
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }
        }

        bw.write((long)Math.pow(res, 2)+"");
        bw.flush();

    }

}
