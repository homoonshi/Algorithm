
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] health = new int[N+1];
        int[] happy = new int[N+1];

        String[] h1 = br.readLine().split(" ");
        String[] h2 = br.readLine().split(" ");

        for(int i=1; i<=N; i++){
            health[i] = Integer.parseInt(h1[i-1]);
            happy[i] = Integer.parseInt(h2[i-1]);
        }

        int[][] dp = new int[N+1][101];
        int res = 0;

        for(int i=1; i<=N; i++){
            for(int j=0; j<100; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
                if(j+health[i] < 100){
                    dp[i][j+health[i]] = Math.max(dp[i-1][j+health[i]], dp[i-1][j] + happy[i]);
                }
                res = Math.max(dp[i][j], res);
            }
        }

        bw.write(res+"");
        bw.flush();

    }
}