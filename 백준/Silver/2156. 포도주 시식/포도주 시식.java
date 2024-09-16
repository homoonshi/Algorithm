
import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int[][] dp;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    dp = new int[n+1][3]; // 포도주 개수, 연속으로 마신 수

    for(int i=0; i<n; i++){

      int num = Integer.parseInt(br.readLine());

      dp[i+1][0] = Math.max(dp[i][0], dp[i][1]);
      dp[i+1][0] = Math.max(dp[i+1][0], dp[i][2]);

      dp[i+1][1] = dp[i][0] + num;

      dp[i+1][2] = dp[i][1] + num;

    }

    int result = Math.max(dp[n][0], dp[n][1]);
    result = Math.max(result, dp[n][2]);

    bw.write(result+"");
    bw.flush();

  }
}