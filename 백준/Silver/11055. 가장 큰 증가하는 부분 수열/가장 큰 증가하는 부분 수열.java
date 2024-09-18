
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    String[] input = br.readLine().split(" ");
    int[] nums = new int[N];

    for(int i=0; i<N; i++){
      nums[i] = Integer.parseInt(input[i]);
    }

    int[] dp = new int[N];

    int result = 0;

    for(int i=0; i<N; i++){
      dp[i] = nums[i];
      for(int j=0; j<i; j++){
        if(nums[i]>nums[j]){
          dp[i] = Math.max(dp[j]+nums[i], dp[i]);
        }
      }
    }

    for(int res : dp){
      result = Math.max(res, result);
    }
    
    bw.write(result+"");
    bw.flush();

  }
}