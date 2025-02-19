
import java.util.*;
import java.io.*;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        dp = new int[1001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        int result = searchDp(n);

        bw.write(result+"");
        bw.flush();
    }

    public static int searchDp(int num){
        for(int i=3; i<=num; i++){
            dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
        }
        return dp[num];
    }

}
