import java.io.*;
import java.util.*;

public class Main {

  static int N, M;
  static int[] memory;
  static int[] count;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");

    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);

    memory = new int[N];
    count = new int[N];

    input=br.readLine().split(" ");

    for(int i=0; i<N; i++){

      memory[i] = Integer.parseInt(input[i]);

    }

    input=br.readLine().split(" ");

    for(int i=0; i<N; i++){

      count[i] = Integer.parseInt(input[i]);

    }

    int result = find();

    bw.write(result+"");
    bw.flush();

  }

  public static int find(){

    int[][] dp = new int[N+1][N*100+1];

    int maxCount = 0;

    for(int i=1; i<=N; i++){

      int mNum = memory[i-1];
      int cNum = count[i-1];

      maxCount += cNum;

      if(i==1) {
        dp[i][cNum] = mNum;
        continue;
      }

      for(int j=0; j<=maxCount; j++){

        if(j>0) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }else{
          dp[i][j] = dp[i-1][j];
        }

        if(j-cNum>=0){
          dp[i][j] = Math.max(dp[i][j], dp[i-1][j-cNum]+mNum);
        }

      }

    }

    for(int i=0; i<=maxCount; i++){

      if(dp[N][i]>=M){
        return i;
      }

    }

    return 0;
  }

}
