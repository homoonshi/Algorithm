
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N+1];

        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            int price = Integer.parseInt(input[i]);
            cards[i+1] = price;
        }

        int[][] dp = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=0; j<=N; j++){
                dp[i][j] = dp[i-1][j];
                if(j-i>=0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-i] + cards[i]);
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-i] + cards[i]);
                }
            }
        }

        bw.write(dp[N][N]+"");
        bw.flush();

    }

}
