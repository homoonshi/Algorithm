
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][10];

        for(int i=1; i<=9; i++){
            dp[1][i] = 1;
        }

        long div = 1000000000;

        for(int i=2; i<=N; i++){

            for(int j=0; j<=9; j++){
                if(j-1>=0){
                    dp[i][j-1] += dp[i-1][j];
                    dp[i][j-1] %= div;
                }
                if(j+1<=9){
                    dp[i][j+1] += dp[i-1][j];
                    dp[i][j+1] %= div;
                }
            }

        }

        long res = 0;

        for(int i=0; i<=9; i++){
            res += dp[N][i];
            res %= div;
        }


        bw.write(res+"");
        bw.flush();

    }

}
