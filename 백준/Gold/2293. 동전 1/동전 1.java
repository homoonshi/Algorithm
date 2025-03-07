
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] dp = new int[k+1];
        int[] coins = new int[n];

        for(int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
            if(coins[i]<=k){
                dp[coins[i]]++;
            }
            for(int j=coins[i]+1; j<=k; j++){
                dp[j] += dp[j-coins[i]];
            }
        }

        bw.write(dp[k]+"");
        bw.flush();

    }

}
