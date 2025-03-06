
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N-1][21];
        int[] nums = new int[N-1];

        String[] input = br.readLine().split(" ");
        nums[0] = Integer.parseInt(input[0]);
        dp[0][nums[0]] = 1;

        for(int i=1; i<N-1; i++){
            nums[i] = Integer.parseInt(input[i]);
            for(int j=0; j<=20; j++){
                if(dp[i-1][j]>0){
                    int plus = j + nums[i];
                    int minus = j - nums[i];
                    if(plus>=0 && plus<=20){
                        dp[i][plus] += dp[i-1][j];
                    }
                    if(minus>=0 && minus<=20){
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }

        int result = Integer.parseInt(input[N-1]);

        bw.write(dp[N-2][result]+"");
        bw.flush();

    }

}
