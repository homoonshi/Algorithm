
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[][] dp = new long[31][31];
        int N;
        int minN = 0;

        while( (N = Integer.parseInt(br.readLine())) != 0){

            if(dp[N][N]!=0){
                bw.write(dp[N][N]+"\n");
                continue;
            }

            for(int w=minN+1; w<=N; w++){
                for(int h=0; h<=w; h++){
                    if(h==0){
                        dp[w][h]=1;
                        continue;
                    }
                    dp[w][h] += dp[w][h-1];
                    if(h < w){
                        dp[w][h] += dp[w-1][h];
                    }
                }
            }

            bw.write(dp[N][N]+"\n");
            minN = Math.max(minN, N);

        }

        bw.flush();

    }

}
