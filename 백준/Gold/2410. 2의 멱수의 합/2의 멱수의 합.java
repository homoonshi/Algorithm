
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+2];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=N; i++){
            if(i%2==1){
                dp[i] = dp[i-1] % 1000000000;
                continue;
            }
            dp[i] = (dp[i-1] + dp[i/2]) % 1000000000;
        }

        bw.write(dp[N]+"");
        bw.flush();
    }

}
