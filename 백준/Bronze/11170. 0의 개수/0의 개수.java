
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        int startIndex = 0;

        for(int test_case=0; test_case<T; test_case++){

            String[] input = br.readLine().split(" ");

            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            int res = 0;

            if(dp[N]!=0 && dp[M]!=0) {
                if(N!=0) {
                    res = dp[M] - dp[N-1];
                }else{
                    res = dp[M];
                }
                bw.write(res+"\n");
                continue;
            }

            int zero = 0;

            for(int i=startIndex; i<=M; i++){

                String s = String.valueOf(i);

                for(int j=0; j<s.length(); j++){
                    if(s.charAt(j)=='0'){
                        zero++;
                    }
                }

                dp[i] = zero;

            }

            startIndex = M;

            if(N!=0) {
                res = dp[M] - dp[N-1];
            }else{
                res = dp[M];
            }

            bw.write(res+"\n");

        }

        bw.flush();

    }
}
