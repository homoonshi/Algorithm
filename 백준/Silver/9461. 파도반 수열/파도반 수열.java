
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        int currentIndex = 5;

        for(int test_case=0; test_case<T; test_case++){

            int N = Integer.parseInt(br.readLine());

            if(N>5 && currentIndex<N){
                for(int i=currentIndex+1; i<=N; i++){
                    dp[i] = dp[i-1] + dp[i-5];
                }
                currentIndex = N;
            }

            bw.write(dp[N]+"\n");

        }

        bw.flush();

    }

}
