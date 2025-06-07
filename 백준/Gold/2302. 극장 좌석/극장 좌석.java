
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[] vip;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        vip = new boolean[N+1];
        dp = new int[2][N+2];

        for(int i=0; i<M; i++){
            int num = Integer.parseInt(br.readLine());
            vip[num] = true;
        }

        if(M==N){
            bw.write("1");
            bw.flush();
            return;
        }

        dp[1][0] = 1;
        dp[1][1] = 1;

        for(int i=2; i<=N; i++){
            if(vip[i]){
                dp[1][i] = dp[0][i-1] + dp[1][i-1];
                continue;
            }
            if(!vip[i-1]) {
                dp[0][i] = dp[0][i-2] + dp[1][i-2];
            }
            dp[1][i] = dp[0][i-1] + dp[1][i-1];
        }

        if(N>1 && !vip[N]) {
            bw.write(dp[0][N] + dp[1][N] + "");
        }else{
            bw.write(dp[1][N]+"");
        }
        bw.flush();

    }

}